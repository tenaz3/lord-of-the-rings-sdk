package org.liblab.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Chapters extends Pagination {
    @JsonProperty("docs")
    private List<Chapter> chapters;

    public List<Chapter> getChapters() {
        return chapters;
    }
}
