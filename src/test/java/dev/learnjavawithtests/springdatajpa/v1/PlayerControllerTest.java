package dev.learnjavawithtests.springdatajpa.v1;

import dev.learnjavawithtests.springsecurity.v1.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
@Import(SecurityConfiguration.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    void createsAPlayer() throws Exception {
        when(playerService.create(any(CreatePlayerRequest.class))).thenReturn(new Player(1L, "Pepper", 2));

        mockMvc.perform(post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Pepper","wins":2}
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {"id":1,"name":"Pepper","wins":2}
                        """));
    }

    @Test
    void getsAPlayer() throws Exception {
        when(playerService.get(1L)).thenReturn(new Player(1L, "Pepper", 2));

        mockMvc.perform(get("/players/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"id":1,"name":"Pepper","wins":2}
                        """));
    }

    @Test
    void listsPlayers() throws Exception {
        when(playerService.list()).thenReturn(List.of(
                new Player(2L, "Pepper", 3),
                new Player(1L, "Chris", 1)
        ));

        mockMvc.perform(get("/players"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                          {"id":2,"name":"Pepper","wins":3},
                          {"id":1,"name":"Chris","wins":1}
                        ]
                        """));
    }

    @Test
    void updatesAPlayer() throws Exception {
        when(playerService.update(any(Long.class), any(UpdatePlayerRequest.class))).thenReturn(new Player(1L, "Chris", 4));

        mockMvc.perform(patch("/players/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Chris","wins":4}
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"id":1,"name":"Chris","wins":4}
                        """));
    }

    @Test
    void deletesAPlayer() throws Exception {
        doNothing().when(playerService).delete(1L);

        mockMvc.perform(delete("/players/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void returnsNotFoundWhenAPlayerDoesNotExist() throws Exception {
        when(playerService.get(99L)).thenThrow(new PlayerNotFoundException(99L));

        mockMvc.perform(get("/players/99"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("""
                        {"error":"player not found: 99"}
                        """));
    }
}
