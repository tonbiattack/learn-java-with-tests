package dev.learnjavawithtests.commandline.v1;

import dev.learnjavawithtests.io.v1.LeagueEntry;

import java.util.List;

public interface PlayerStore {
    void recordWin(String playerName);

    List<LeagueEntry> leagueTable();
}

