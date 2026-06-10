package dev.learnjavawithtests.springvalidation.v1;

public final class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("email already registered: " + email);
    }
}

