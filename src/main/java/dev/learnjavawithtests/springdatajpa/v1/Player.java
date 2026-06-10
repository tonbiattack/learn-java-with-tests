package dev.learnjavawithtests.springdatajpa.v1;

public record Player(Long id, String name, int wins) {
    static Player fromEntity(PlayerEntity entity) {
        return new Player(entity.getId(), entity.getName(), entity.getWins());
    }
}

