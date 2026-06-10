package dev.learnjavawithtests.springdatajpa.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void persistsAndLoadsPlayers() {
        PlayerEntity saved = playerRepository.save(new PlayerEntity("Pepper", 2));

        PlayerEntity found = playerRepository.findById(saved.getId()).orElseThrow();

        assertEquals("Pepper", found.getName());
        assertEquals(2, found.getWins());
    }

    @Test
    void sortsByWinsDescendingThenNameAscending() {
        playerRepository.save(new PlayerEntity("Chris", 2));
        playerRepository.save(new PlayerEntity("Pepper", 3));
        playerRepository.save(new PlayerEntity("Alex", 2));

        List<PlayerEntity> players = playerRepository.findAllByOrderByWinsDescNameAsc();

        assertEquals(List.of("Pepper", "Alex", "Chris"), players.stream().map(PlayerEntity::getName).toList());
    }

    @Test
    void detectsExistingNames() {
        playerRepository.save(new PlayerEntity("Pepper", 1));

        assertTrue(playerRepository.existsByName("Pepper"));
    }
}

