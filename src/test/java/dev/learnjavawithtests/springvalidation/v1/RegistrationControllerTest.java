package dev.learnjavawithtests.springvalidation.v1;

import dev.learnjavawithtests.springsecurity.v1.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegistrationController.class)
@Import({ApiErrorHandler.class, SecurityConfiguration.class})
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RegistrationService registrationService;

    @Test
    void registersAUser() throws Exception {
        when(registrationService.register(any(RegisterUserRequest.class)))
                .thenReturn(new Registration(1L, "Pepper", "pepper@example.com"));

        mockMvc.perform(post("/registrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Pepper","email":"pepper@example.com"}
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {"id":1,"name":"Pepper","email":"pepper@example.com"}
                        """));
    }

    @Test
    void rejectsInvalidInput() throws Exception {
        mockMvc.perform(post("/registrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"","email":"not-an-email"}
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("""
                        {"errors":{"name":"must not be blank","email":"must be a well-formed email address"}}
                        """));
    }

    @Test
    void returnsConflictForDuplicateEmails() throws Exception {
        when(registrationService.register(any(RegisterUserRequest.class)))
                .thenThrow(new DuplicateEmailException("pepper@example.com"));

        mockMvc.perform(post("/registrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Pepper","email":"pepper@example.com"}
                                """))
                .andExpect(status().isConflict())
                .andExpect(content().json("""
                        {"error":"email already registered: pepper@example.com"}
                        """));
    }
}
