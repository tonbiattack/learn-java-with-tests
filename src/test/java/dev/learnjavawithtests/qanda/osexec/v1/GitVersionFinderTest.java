package dev.learnjavawithtests.qanda.osexec.v1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GitVersionFinderTest {

    @Test
    void returnsTheVersionOutputFromTheCommandRunner() throws IOException, InterruptedException {
        GitVersionFinder finder = new GitVersionFinder(command -> "git version 2.51.0");

        assertEquals("git version 2.51.0", finder.version());
    }
}

