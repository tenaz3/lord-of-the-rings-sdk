package client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movies extends Pagination {
    @JsonProperty("docs")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

}
