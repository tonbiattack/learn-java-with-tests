package dev.learnjavawithtests.springrestclient.v1;

public final class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(long id) {
        super("quote not found: " + id);
    }
}

