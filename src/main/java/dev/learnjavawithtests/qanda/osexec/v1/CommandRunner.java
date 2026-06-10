package dev.learnjavawithtests.qanda.osexec.v1;

import java.io.IOException;

public interface CommandRunner {
    String run(String... command) throws IOException, InterruptedException;
}

