package dev.learnjavawithtests.springvalidation.v1;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
        @NotBlank String name,
        @NotBlank @Email String email
) {
}

