package dev.learnjavawithtests.io.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilePlayerStoreTest {

    @TempDir
    Path tempDir;

    @Test
    void returnsZeroForUnknownPlayers() throws IOException {
        FilePlayerStore store = newStore();

        assertEquals(0, store.scoreFor("Pepper"));
    }

    @Test
    void recordsWinsAndReadsThemBack() throws IOException {
        FilePlayerStore store = newStore();

        store.recordWin("Pepper");
        store.recordWin("Pepper");

        assertEquals(2, store.scoreFor("Pepper"));
    }

    @Test
    void returnsALeagueTableSortedByWins() throws IOException {
        FilePlayerStore store = newStore();
        store.recordWin("Chris");
        store.recordWin("Pepper");
        store.recordWin("Pepper");

        assertEquals(
                List.of(
                        new LeagueEntry("Pepper", 2),
                        new LeagueEntry("Chris", 1)
                ),
                store.leagueTable()
        );
    }

    private FilePlayerStore newStore() {
        return new FilePlayerStore(tempDir.resolve("league.json"), new ObjectMapper());
    }
}

