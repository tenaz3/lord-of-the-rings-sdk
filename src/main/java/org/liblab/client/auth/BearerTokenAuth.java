package org.liblab.client.auth;

import java.util.Map;

public class BearerTokenAuth {
    private final String accessToken;

    public BearerTokenAuth(String accessToken) {
        this.accessToken = accessToken;
    }

    public void applyToParams(Map<String, String> headerParams) {
        if (accessToken != null) {
            headerParams.put("Authorization", "Bearer " + accessToken);
        }
    }
}
