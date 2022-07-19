package org.liblab.client.api;

import org.liblab.client.ApiClient;
import org.liblab.client.Configuration;
import org.liblab.client.Pair;
import client.model.*;
import org.liblab.client.model.Character;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.okhttp.Call;
import org.liblab.client.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotrApi {

    private final ApiClient apiClient;

    public LotrApi(Configuration configuration) {
        this.apiClient = new ApiClient(configuration);
    }

    public LotrApi() {
        this.apiClient = new ApiClient(new Configuration());
    }


    /**
     * Get all books
     *
     * @return Books
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Books getBooks() throws JsonProcessingException {
        Call call = getCall("/book");
        return apiClient.execute(call, Books.class);
    }

    /**
     * Get book with {id}
     *
     * @return Book
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Book getBook(String id) throws JsonProcessingException {
        Call call = getCall("/book/" + id);
        Books books = apiClient.execute(call, Books.class);
        return books.getBooks().get(0);
    }

    /**
     * Get chapters of a book with {id}
     *
     * @return Book chapters
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Chapters getBookChapter(String id) throws JsonProcessingException {
        Call call = getCall("/book/" + id + "/chapter");
        return apiClient.execute(call, Chapters.class);
    }

    /**
     * Get all chapters
     *
     * @return Books
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Chapters getChapters() throws JsonProcessingException {
        Call call = getCall("/chapter");
        return apiClient.execute(call, Chapters.class);
    }

    /**
     * Get chapter with {id}
     *
     * @return Chapter
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Chapter getChapter(String id) throws JsonProcessingException {
        Call call = getCall("/chapter/" + id);
        Chapters chapters = apiClient.execute(call, Chapters.class);
        return chapters.getChapters().get(0);
    }

    /**
     * Get all movies
     *
     * @return Movies
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Movies getMovies() throws JsonProcessingException {
        Call call = getCall("/movie");
        return apiClient.execute(call, Movies.class);
    }

    /**
     * Get movie with {id}
     *
     * @return Movie
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Movie getMovie(String id) throws JsonProcessingException {
        Call call = getCall("/movie/" + id);
        Movies movies = apiClient.execute(call, Movies.class);
        return movies.getMovies().get(0);
    }

    /**
     * Get quotes of movie with {id}
     *
     * @return Quotes
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Quotes getMovieQuotes(String id) throws JsonProcessingException {
        Call call = getCall("/movie/" + id + "/quote");
        return apiClient.execute(call, Quotes.class);
    }

    /**
     * Get all characters
     *
     * @return Characters
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Characters getCharacters() throws JsonProcessingException {
        Call call = getCall("/character");
        return apiClient.execute(call, Characters.class);
    }

    /**
     * Get character with {id}
     *
     * @return Character
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Character getCharacter(String id) throws JsonProcessingException {
        Call call = getCall("/character/" + id);
        Characters characters = apiClient.execute(call, Characters.class);
        return characters.getCharacters().get(0);
    }

    /**
     * Get character quotes with {id}
     *
     * @return Quotes
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Quotes getCharacterQuotes(String id) throws JsonProcessingException {
        Call call = getCall("/character/" + id + "/quote");
        return apiClient.execute(call, Quotes.class);
    }

    /**
     * Get all quotes
     *
     * @return Quotes
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Quotes getQuotes() throws JsonProcessingException {
        Call call = getCall("/quote");
        return apiClient.execute(call, Quotes.class);
    }

    /**
     * Get quote with {id}
     *
     * @return Quote
     * @throws JsonProcessingException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Quote getQuote(String id) throws JsonProcessingException {
        Call call = getCall("/quote/" + id);
        Quotes characters = apiClient.execute(call, Quotes.class);
        return characters.getQuotes().get(0);
    }

    /**
     * Build call for get
     *
     * @return Call to execute
     * @throws JsonProcessingException If fail to serialize the request body object
     */
    private Call getCall(String path) throws JsonProcessingException {

        List<Pair> localVarQueryParams = new ArrayList<>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        return apiClient.buildCall(path, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams);
    }
}
