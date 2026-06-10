package dev.learnjavawithtests.springvalidation.v1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegistrationServiceTest {

    @Test
    void registersANewUser() {
        RegistrationService service = new RegistrationService(new FakeRegistrationStore());

        Registration registration = service.register(new RegisterUserRequest("Pepper", "pepper@example.com"));

        assertEquals(new Registration(1L, "Pepper", "pepper@example.com"), registration);
    }

    @Test
    void rejectsDuplicateEmails() {
        FakeRegistrationStore store = new FakeRegistrationStore();
        RegistrationService service = new RegistrationService(store);
        service.register(new RegisterUserRequest("Pepper", "pepper@example.com"));

        assertThrows(
                DuplicateEmailException.class,
                () -> service.register(new RegisterUserRequest("Chris", "pepper@example.com"))
        );
    }

    private static final class FakeRegistrationStore implements RegistrationStore {
        private final AtomicLong ids = new AtomicLong();
        private final Map<String, Registration> registrations = new HashMap<>();

        @Override
        public boolean existsByEmail(String email) {
            return registrations.containsKey(email);
        }

        @Override
        public Registration save(String name, String email) {
            Registration registration = new Registration(ids.incrementAndGet(), name, email);
            registrations.put(email, registration);
            return registration;
        }
    }
}

