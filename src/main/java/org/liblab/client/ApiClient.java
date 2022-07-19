package org.liblab.client;

import org.liblab.client.auth.BearerTokenAuth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ApiClient {

    private final String basePath = "https://the-one-api.dev/v2";

    BearerTokenAuth auth;

    private final OkHttpClient httpClient;

    private ObjectMapper mapper;


    public ApiClient(Configuration configuration) {
        httpClient = new OkHttpClient();

        mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        auth = new BearerTokenAuth(configuration.getAccessToken());
    }


    /**
     * Build HTTP call with the given options.
     *
     * @param path                  The sub-path of the HTTP URL
     * @param method                The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and "DELETE"
     * @param queryParams           The query parameters
     * @param collectionQueryParams The collection query parameters
     * @param body                  The request body object
     * @param headerParams          The header parameters
     * @return The HTTP call
     * @throws JsonProcessingException If fail to serialize the request body object
     */
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams) throws JsonProcessingException {
        Request request = buildRequest(path, method, queryParams, collectionQueryParams, body, headerParams);

        return httpClient.newCall(request);
    }

    /**
     * Build an HTTP request with the given options.
     *
     * @param path                  The sub-path of the HTTP URL
     * @param method                The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and "DELETE"
     * @param queryParams           The query parameters
     * @param collectionQueryParams The collection query parameters
     * @param body                  The request body object
     * @param headerParams          The header parameters
     * @return The HTTP request
     * @throws JsonProcessingException If fail to serialize the request body object
     */
    public Request buildRequest(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams) throws JsonProcessingException {
        final String url;

        auth.applyToParams(headerParams);

        url = buildUrl(path, queryParams, collectionQueryParams);

        final Request.Builder reqBuilder = new Request.Builder().url(url);
        processHeaderParams(headerParams, reqBuilder);


        RequestBody reqBody = null;
        if (body != null)
            reqBody = serialize(body, "application/json");

        return reqBuilder.method(method, reqBody).build();
    }


    /**
     * Serialize the given Java object into request body according to the object's
     * class and the request Content-Type.
     *
     * @param obj         The Java object
     * @param contentType The request Content-Type
     * @return The serialized request body
     * @throws JsonProcessingException If fail to serialize the given object
     */
    public RequestBody serialize(Object obj, String contentType) throws JsonProcessingException {
        return RequestBody.create(MediaType.parse(contentType), mapper.writeValueAsString(obj));
    }


    /**
     * Build full URL by concatenating base path, the given sub path and query parameters.
     *
     * @param path                  The sub path
     * @param queryParams           The query parameters
     * @param collectionQueryParams The collection query parameters
     * @return The full URL
     */
    public String buildUrl(String path, List<Pair> queryParams, List<Pair> collectionQueryParams) throws JsonProcessingException {
        final StringBuilder url = new StringBuilder();
        url.append(basePath).append(path);

        if (queryParams != null && !queryParams.isEmpty()) {
            // support (constant) query string in `path`, e.g. "/posts?draft=1"
            String prefix = path.contains("?") ? "&" : "?";
            for (Pair param : queryParams) {
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }
                    String value = parameterToString(param.getValue());
                    url.append(escapeString(param.getName())).append("=").append(escapeString(value));
                }
            }
        }

        if (collectionQueryParams != null && !collectionQueryParams.isEmpty()) {
            String prefix = url.toString().contains("?") ? "&" : "?";
            for (Pair param : collectionQueryParams) {
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }
                    String value = parameterToString(param.getValue());
                    // collection query parameter value already escaped as part of parameterToPairs
                    url.append(escapeString(param.getName())).append("=").append(value);
                }
            }
        }

        return url.toString();
    }

    /**
     * Format the given parameter object into string.
     *
     * @param param Parameter
     * @return String representation of the parameter
     */
    public String parameterToString(Object param) throws JsonProcessingException {
        if (param == null) {
            return "";
        } else if (param instanceof Date || param instanceof OffsetDateTime || param instanceof LocalDate) {
            //Serialize to json string and remove the " enclosing characters
            String jsonStr = mapper.writeValueAsString(param);
            return jsonStr.substring(1, jsonStr.length() - 1);
        } else if (param instanceof Collection) {
            StringBuilder b = new StringBuilder();
            for (Object o : (Collection) param) {
                if (b.length() > 0) {
                    b.append(",");
                }
                b.append(o);
            }
            return b.toString();
        } else {
            return String.valueOf(param);
        }
    }

    /**
     * Escape the given string to be used as URL query value.
     *
     * @param str String to be escaped
     * @return Escaped string
     */
    public String escapeString(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
    }

    /**
     * Set header parameters to the request builder, including default headers.
     *
     * @param headerParams Header parameters in the from of Map
     * @param reqBuilder   Request.Builder
     */
    public void processHeaderParams(Map<String, String> headerParams, Request.Builder reqBuilder) throws JsonProcessingException {
        for (Map.Entry<String, String> param : headerParams.entrySet()) {
            reqBuilder.header(param.getKey(), parameterToString(param.getValue()));
        }
    }

    /**
     * Execute HTTP call and deserialize the HTTP response body into the given return type.
     *
     * @param klass The return type used to deserialize HTTP response body
     * @param <T>   The return type corresponding to (same with) klass
     * @param call  Call
     * @return ApiResponse object containing response status, headers and
     * data, which is a Java object deserialized from response body and would be null
     * when klass is null.
     * @throws RuntimeException If fail to execute the call
     */
    public <T> T execute(Call call, Class<T> klass) throws RuntimeException {
        try {
            Response response = call.execute();
            T t = mapper.readValue(response.body().string(), klass);
            response.body().close();
            return t;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
