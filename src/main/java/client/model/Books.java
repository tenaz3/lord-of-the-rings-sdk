package client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Books extends Pagination {
    @JsonProperty("docs")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

}
