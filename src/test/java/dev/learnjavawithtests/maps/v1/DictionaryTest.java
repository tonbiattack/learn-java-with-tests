package dev.learnjavawithtests.maps.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DictionaryTest {

    @Test
    void searchesForAddedWords() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("test", "this is just a test");

        assertEquals("this is just a test", dictionary.search("test"));
    }

    @Test
    void throwsForUnknownWords() {
        Dictionary dictionary = new Dictionary();

        assertThrows(WordNotFoundException.class, () -> dictionary.search("missing"));
    }

    @Test
    void addingAnExistingWordFails() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("test", "first");

        assertThrows(WordAlreadyExistsException.class, () -> dictionary.add("test", "second"));
        assertEquals("first", dictionary.search("test"));
    }

    @Test
    void updatesExistingWords() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("test", "first");

        dictionary.update("test", "second");

        assertEquals("second", dictionary.search("test"));
    }

    @Test
    void updatingUnknownWordsFails() {
        Dictionary dictionary = new Dictionary();

        assertThrows(WordNotFoundException.class, () -> dictionary.update("missing", "value"));
    }

    @Test
    void deletesWords() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("test", "value");

        dictionary.delete("test");

        assertThrows(WordNotFoundException.class, () -> dictionary.search("test"));
    }
}

