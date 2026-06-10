package dev.learnjavawithtests.springdatajpa.v1;

public final class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("player not found: " + id);
    }
}

