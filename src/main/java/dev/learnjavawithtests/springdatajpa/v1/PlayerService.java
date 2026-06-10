package dev.learnjavawithtests.springdatajpa.v1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create(CreatePlayerRequest request) {
        if (playerRepository.existsByName(request.name())) {
            throw new DuplicatePlayerException(request.name());
        }

        PlayerEntity player = playerRepository.save(new PlayerEntity(request.name(), request.wins()));
        return Player.fromEntity(player);
    }

    @Transactional(readOnly = true)
    public Player get(long id) {
        return Player.fromEntity(findPlayer(id));
    }

    @Transactional(readOnly = true)
    public List<Player> list() {
        return playerRepository.findAllByOrderByWinsDescNameAsc().stream()
                .map(Player::fromEntity)
                .toList();
    }

    public Player update(long id, UpdatePlayerRequest request) {
        PlayerEntity player = findPlayer(id);
        player.rename(request.name());
        player.setWins(request.wins());
        return Player.fromEntity(playerRepository.save(player));
    }

    public void delete(long id) {
        PlayerEntity player = findPlayer(id);
        playerRepository.delete(player);
    }

    private PlayerEntity findPlayer(long id) {
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }
}

