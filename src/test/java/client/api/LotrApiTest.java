package client.api;

import org.liblab.client.Configuration;
import org.liblab.client.api.LotrApi;
import org.liblab.client.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.liblab.client.model.Character;

import static org.junit.Assert.assertEquals;

public class LotrApiTest {

    private final LotrApi api = new LotrApi(new Configuration().setAccessToken("TpQvuz298mWZGRgiiEys"));

    @Test
    public void getBook() throws JsonProcessingException {
        Book book = api.getBook("5cf5805fb53e011a64671582");
        assertEquals("The Fellowship Of The Ring", book.getName());
    }

    @Test
    public void getBooks() throws JsonProcessingException {
        Books books = api.getBooks();
        assertEquals(3, books.getBooks().size());
    }

    @Test
    public void getChaptersOfBook() throws JsonProcessingException {
        Chapters chapters = api.getBookChapter("5cf5805fb53e011a64671582");
        assertEquals(22, chapters.getChapters().size());
    }

    @Test
    public void getChapters() throws JsonProcessingException {
        Chapters chapters = api.getChapters();
        assertEquals(62, chapters.getChapters().size());
    }

    @Test
    public void getChapter() throws JsonProcessingException {
        Chapter chapter = api.getChapter("6091b6d6d58360f988133bc7");
        assertEquals("The Scouring of the Shire", chapter.getChapterName());
    }


    @Test
    public void getMovies() throws JsonProcessingException {
        Movies movies = api.getMovies();
        assertEquals(8, movies.getMovies().size());
    }

    @Test
    public void getMovie() throws JsonProcessingException {
        Movie movie = api.getMovie("5cd95395de30eff6ebccde5c");
        assertEquals("The Fellowship of the Ring", movie.getName());
    }

    @Test
    public void getMovieQuotes() throws JsonProcessingException {
        Quotes quotes = api.getMovieQuotes("5cd95395de30eff6ebccde5c");
        assertEquals(507, quotes.getTotal());
    }

    @Test
    public void getCharacters() throws JsonProcessingException {
        Characters characters = api.getCharacters();
        assertEquals(933, characters.getTotal());
    }

    @Test
    public void getCharacter() throws JsonProcessingException {
        Character characters = api.getCharacter("5cd99d4bde30eff6ebccfbc1");
        assertEquals("Golden", characters.getHair());
        assertEquals("Elf", characters.getRace());
    }

    @Test
    public void getCharacterQuotes() throws JsonProcessingException {
        Quotes quotes = api.getCharacterQuotes("5cd99d4bde30eff6ebccfea0");
        assertEquals(216, quotes.getTotal());
    }

    @Test
    public void getQuotes() throws JsonProcessingException {
        Quotes characters = api.getQuotes();
        assertEquals(2390, characters.getTotal());
    }

    @Test
    public void getQuote() throws JsonProcessingException {
        Quote quote = api.getQuote("5cd96e05de30eff6ebccebd0");
        assertEquals("Get the wounded on horses.The wolves of lsengard will return.Leave the dead.", quote.getDialog());
    }
}