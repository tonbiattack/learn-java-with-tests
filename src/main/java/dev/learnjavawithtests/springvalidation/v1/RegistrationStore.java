package dev.learnjavawithtests.springvalidation.v1;

public interface RegistrationStore {
    boolean existsByEmail(String email);

    Registration save(String name, String email);
}

