package dev.learnjavawithtests.commandline.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.learnjavawithtests.io.v1.LeagueEntry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeagueCliTest {

    @Test
    void recordsAWinForTheNamedPlayer() throws IOException {
        SpyPlayerStore playerStore = new SpyPlayerStore();

        new LeagueCli(playerStore, new ObjectMapper()).play(new StringReader("Pepper wins"), new StringWriter());

        assertEquals(List.of("Pepper"), playerStore.recordedWins);
    }

    @Test
    void printsTheLeagueAsJson() throws IOException {
        SpyPlayerStore playerStore = new SpyPlayerStore();
        playerStore.league = List.of(new LeagueEntry("Pepper", 2), new LeagueEntry("Chris", 1));
        StringWriter output = new StringWriter();

        new LeagueCli(playerStore, new ObjectMapper()).play(new StringReader("league"), output);

        assertEquals("[{\"name\":\"Pepper\",\"wins\":2},{\"name\":\"Chris\",\"wins\":1}]", output.toString());
    }

    private static final class SpyPlayerStore implements PlayerStore {
        private final List<String> recordedWins = new ArrayList<>();
        private List<LeagueEntry> league = List.of();

        @Override
        public void recordWin(String playerName) {
            recordedWins.add(playerName);
        }

        @Override
        public List<LeagueEntry> leagueTable() {
            return league;
        }
    }
}

