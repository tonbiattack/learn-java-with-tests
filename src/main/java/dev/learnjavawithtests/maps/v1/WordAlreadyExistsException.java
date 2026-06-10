package dev.learnjavawithtests.maps.v1;

public final class WordAlreadyExistsException extends RuntimeException {
    public WordAlreadyExistsException(String word) {
        super("word already exists: " + word);
    }
}

