package dev.learnjavawithtests.springdatajpa.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player create(@RequestBody CreatePlayerRequest request) {
        return playerService.create(request);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable long id) {
        return playerService.get(id);
    }

    @GetMapping
    public List<Player> list() {
        return playerService.list();
    }

    @PatchMapping("/{id}")
    public Player update(@PathVariable long id, @RequestBody UpdatePlayerRequest request) {
        return playerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        playerService.delete(id);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(PlayerNotFoundException exception) {
        return Map.of("error", exception.getMessage());
    }

    @ExceptionHandler(DuplicatePlayerException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleDuplicate(DuplicatePlayerException exception) {
        return Map.of("error", exception.getMessage());
    }
}

