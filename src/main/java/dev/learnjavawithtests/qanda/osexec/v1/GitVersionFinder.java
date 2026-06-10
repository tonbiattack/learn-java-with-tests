package dev.learnjavawithtests.qanda.osexec.v1;

import java.io.IOException;

public final class GitVersionFinder {
    private final CommandRunner commandRunner;

    public GitVersionFinder(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

    public String version() throws IOException, InterruptedException {
        return commandRunner.run("git", "--version");
    }
}

