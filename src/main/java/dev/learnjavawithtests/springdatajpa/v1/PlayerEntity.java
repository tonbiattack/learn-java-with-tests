package dev.learnjavawithtests.springdatajpa.v1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int wins;

    @Version
    private long version;

    protected PlayerEntity() {
    }

    public PlayerEntity(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void rename(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}

