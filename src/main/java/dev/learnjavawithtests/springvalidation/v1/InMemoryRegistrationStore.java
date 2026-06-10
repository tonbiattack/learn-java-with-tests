package dev.learnjavawithtests.springvalidation.v1;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryRegistrationStore implements RegistrationStore {
    private final AtomicLong ids = new AtomicLong(0);
    private final Map<String, Registration> registrationsByEmail = new ConcurrentHashMap<>();

    @Override
    public boolean existsByEmail(String email) {
        return registrationsByEmail.containsKey(email);
    }

    @Override
    public Registration save(String name, String email) {
        Registration registration = new Registration(ids.incrementAndGet(), name, email);
        registrationsByEmail.put(email, registration);
        return registration;
    }
}

