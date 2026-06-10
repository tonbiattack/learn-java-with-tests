package dev.learnjavawithtests.maps.v1;

public final class WordNotFoundException extends RuntimeException {
    public WordNotFoundException(String word) {
        super("word not found: " + word);
    }
}

