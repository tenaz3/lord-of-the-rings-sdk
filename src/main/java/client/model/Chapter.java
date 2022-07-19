package client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Chapter implements Serializable {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("chapterName")
    private String chapterName;

    @JsonProperty("book")
    private String bookId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(id, chapter.id) && Objects.equals(chapterName, chapter.chapterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chapterName);
    }

    public String getChapterName() {
        return chapterName;
    }
}
