package dev.learnjavawithtests.springsecurity.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SecureApiController.class)
@Import(SecurityConfiguration.class)
class SecureApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProfileService profileService;

    @MockitoBean
    private AdminReportService adminReportService;

    @Test
    void requiresAuthenticationForProfile() throws Exception {
        mockMvc.perform(get("/security/profile"))
                .andExpect(status().isUnauthorized())
                .andExpect(header().string("WWW-Authenticate", "Basic realm=\"Realm\""));
    }

    @Test
    void returnsProfileForAuthenticatedUsers() throws Exception {
        when(profileService.profileFor(org.mockito.ArgumentMatchers.any()))
                .thenReturn(new ProfileResponse("pepper", java.util.List.of("ROLE_USER")));

        mockMvc.perform(get("/security/profile")
                        .with(user("pepper").roles("USER"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"username":"pepper","authorities":["ROLE_USER"]}
                        """));
    }

    @Test
    void rejectsNonAdminUsersFromAdminEndpoints() throws Exception {
        mockMvc.perform(post("/security/admin/reports")
                        .with(user("pepper").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"weekly-summary"}
                                """))
                .andExpect(status().isForbidden());
    }

    @Test
    void allowsAdminUsersToCreateReports() throws Exception {
        when(adminReportService.createReport("weekly-summary"))
                .thenReturn(new AdminReportResponse("created report: weekly-summary"));

        mockMvc.perform(post("/security/admin/reports")
                        .with(user("boss").roles("ADMIN", "USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"weekly-summary"}
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {"message":"created report: weekly-summary"}
                        """));
    }

    @Test
    void supportsHttpBasicAuthenticationToo() throws Exception {
        when(profileService.profileFor(org.mockito.ArgumentMatchers.any()))
                .thenReturn(new ProfileResponse("pepper", java.util.List.of("ROLE_USER")));

        mockMvc.perform(get("/security/profile")
                        .with(httpBasic("pepper", "password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"username":"pepper","authorities":["ROLE_USER"]}
                        """));
    }
}
