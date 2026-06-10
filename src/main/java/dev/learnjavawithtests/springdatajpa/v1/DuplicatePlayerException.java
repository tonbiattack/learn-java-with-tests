package dev.learnjavawithtests.springdatajpa.v1;

public final class DuplicatePlayerException extends RuntimeException {
    public DuplicatePlayerException(String name) {
        super("player already exists: " + name);
    }
}

