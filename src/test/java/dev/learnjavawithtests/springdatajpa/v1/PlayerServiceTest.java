package dev.learnjavawithtests.springdatajpa.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void createsAPlayer() {
        when(playerRepository.existsByName("Pepper")).thenReturn(false);
        when(playerRepository.save(any(PlayerEntity.class))).thenAnswer(invocation -> {
            PlayerEntity entity = invocation.getArgument(0);
            PlayerEntity saved = new PlayerEntity(entity.getName(), entity.getWins());
            var idField = PlayerEntity.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(saved, 1L);
            return saved;
        });

        Player player = playerService.create(new CreatePlayerRequest("Pepper", 2));

        assertEquals(new Player(1L, "Pepper", 2), player);
    }

    @Test
    void rejectsDuplicateNames() {
        when(playerRepository.existsByName("Pepper")).thenReturn(true);

        assertThrows(DuplicatePlayerException.class, () -> playerService.create(new CreatePlayerRequest("Pepper", 2)));
    }

    @Test
    void listsPlayersInRepositoryOrder() {
        when(playerRepository.findAllByOrderByWinsDescNameAsc()).thenReturn(List.of(
                player(2L, "Pepper", 3),
                player(1L, "Chris", 1)
        ));

        assertEquals(
                List.of(new Player(2L, "Pepper", 3), new Player(1L, "Chris", 1)),
                playerService.list()
        );
    }

    @Test
    void updatesAnExistingPlayer() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player(1L, "Pepper", 2)));
        when(playerRepository.save(any(PlayerEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Player updated = playerService.update(1L, new UpdatePlayerRequest("Chris", 4));

        assertEquals(new Player(1L, "Chris", 4), updated);
    }

    @Test
    void deletesAnExistingPlayer() {
        PlayerEntity entity = player(1L, "Pepper", 2);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(entity));

        playerService.delete(1L);

        ArgumentCaptor<PlayerEntity> captor = ArgumentCaptor.forClass(PlayerEntity.class);
        verify(playerRepository).delete(captor.capture());
        assertEquals(1L, captor.getValue().getId());
    }

    @Test
    void failsWhenAPlayerCannotBeFound() {
        when(playerRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(PlayerNotFoundException.class, () -> playerService.get(999L));
    }

    private static PlayerEntity player(long id, String name, int wins) {
        try {
            PlayerEntity entity = new PlayerEntity(name, wins);
            var idField = PlayerEntity.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
            return entity;
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException(exception);
        }
    }
}

