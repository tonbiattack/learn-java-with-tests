package dev.learnjavawithtests.springdatajpa.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create-drop")
class PlayerRepositoryPostgresContainerTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17-alpine");

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void persistsAndLoadsPlayersUsingPostgres() {
        PlayerEntity saved = playerRepository.save(new PlayerEntity("Pepper", 2));

        PlayerEntity found = playerRepository.findById(saved.getId()).orElseThrow();

        assertEquals("Pepper", found.getName());
        assertEquals(2, found.getWins());
    }

    @Test
    void sortsUsingTheRealDatabase() {
        playerRepository.save(new PlayerEntity("Chris", 2));
        playerRepository.save(new PlayerEntity("Pepper", 3));
        playerRepository.save(new PlayerEntity("Alex", 2));

        List<PlayerEntity> players = playerRepository.findAllByOrderByWinsDescNameAsc();

        assertEquals(List.of("Pepper", "Alex", "Chris"), players.stream().map(PlayerEntity::getName).toList());
    }
}
