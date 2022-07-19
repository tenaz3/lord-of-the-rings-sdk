package client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Movie implements Serializable {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("runtimeInMinutes")
    private int runtimeInMinutes;

    @JsonProperty("budgetInMillions")
    private int budgetInMillions;

    @JsonProperty("boxOfficeRevenueInMillions")
    private double boxOfficeRevenueInMillions;

   @JsonProperty("academyAwardNominations")
    private int academyAwardNominations;

   @JsonProperty("rottenTomatoesScore")
    private int rottenTomatoesScore;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
