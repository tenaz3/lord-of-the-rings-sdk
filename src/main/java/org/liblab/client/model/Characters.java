package org.liblab.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Characters extends Pagination {
    @JsonProperty("docs")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }

}
