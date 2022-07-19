package org.liblab.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Quote implements Serializable {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("dialog")
    private String dialog;

    @JsonProperty("movie")
    private String movie;

    @JsonProperty("character")
    private String character;

    public String getDialog() {
        return dialog;
    }

    public String getMovie() {
        return movie;
    }
}
