package dev.learnjavawithtests.io.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FilePlayerStore {
    private static final TypeReference<Map<String, Integer>> SCORE_TYPE = new TypeReference<>() { };

    private final Path filePath;
    private final ObjectMapper objectMapper;

    public FilePlayerStore(Path filePath, ObjectMapper objectMapper) {
        this.filePath = filePath;
        this.objectMapper = objectMapper;
    }

    public int scoreFor(String playerName) throws IOException {
        return readScores().getOrDefault(playerName, 0);
    }

    public void recordWin(String playerName) throws IOException {
        Map<String, Integer> scores = readScores();
        scores.merge(playerName, 1, Integer::sum);
        writeScores(scores);
    }

    public List<LeagueEntry> leagueTable() throws IOException {
        List<LeagueEntry> league = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : readScores().entrySet()) {
            league.add(new LeagueEntry(entry.getKey(), entry.getValue()));
        }

        league.sort(Comparator.comparingInt(LeagueEntry::wins).reversed().thenComparing(LeagueEntry::name));
        return league;
    }

    private Map<String, Integer> readScores() throws IOException {
        ensureFileExists();
        return objectMapper.readValue(filePath.toFile(), SCORE_TYPE);
    }

    private void writeScores(Map<String, Integer> scores) throws IOException {
        objectMapper.writeValue(filePath.toFile(), scores);
    }

    private void ensureFileExists() throws IOException {
        if (Files.exists(filePath)) {
            return;
        }

        Files.createDirectories(filePath.getParent());
        writeScores(new LinkedHashMap<>());
    }
}

