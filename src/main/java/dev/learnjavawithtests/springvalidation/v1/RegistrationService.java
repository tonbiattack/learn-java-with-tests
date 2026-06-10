package dev.learnjavawithtests.springvalidation.v1;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final RegistrationStore registrationStore;

    public RegistrationService(RegistrationStore registrationStore) {
        this.registrationStore = registrationStore;
    }

    public Registration register(RegisterUserRequest request) {
        if (registrationStore.existsByEmail(request.email())) {
            throw new DuplicateEmailException(request.email());
        }

        return registrationStore.save(request.name(), request.email());
    }
}

