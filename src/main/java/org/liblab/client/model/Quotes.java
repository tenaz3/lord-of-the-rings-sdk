package org.liblab.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Quotes extends Pagination {
    @JsonProperty("docs")
    private List<Quote> quotes;

    public List<Quote> getQuotes() {
        return quotes;
    }

}
