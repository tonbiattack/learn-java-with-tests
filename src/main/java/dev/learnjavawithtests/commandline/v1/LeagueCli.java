package dev.learnjavawithtests.commandline.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.learnjavawithtests.io.v1.LeagueEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public final class LeagueCli {
    private final PlayerStore playerStore;
    private final ObjectMapper objectMapper;

    public LeagueCli(PlayerStore playerStore, ObjectMapper objectMapper) {
        this.playerStore = playerStore;
        this.objectMapper = objectMapper;
    }

    public void play(Reader input, Writer output) throws IOException {
        String line = new BufferedReader(input).readLine();
        if (line == null || line.isBlank()) {
            return;
        }

        if (line.equalsIgnoreCase("league")) {
            output.write(toJson(playerStore.leagueTable()));
            return;
        }

        if (line.endsWith(" wins")) {
            String playerName = line.substring(0, line.length() - " wins".length());
            playerStore.recordWin(playerName);
        }
    }

    private String toJson(List<LeagueEntry> league) {
        try {
            return objectMapper.writeValueAsString(league);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException(exception);
        }
    }
}

