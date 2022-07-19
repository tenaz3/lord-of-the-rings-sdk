package org.liblab.client;

public class Configuration {

    private String accessToken;

    public Configuration setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
