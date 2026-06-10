package dev.learnjavawithtests.qanda.osexec.v1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class ProcessCommandRunner implements CommandRunner {
    @Override
    public String run(String... command) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(command).start();
        int exitCode = process.waitFor();
        String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
        if (exitCode != 0) {
            throw new IOException("command failed with exit code " + exitCode);
        }
        return output;
    }
}

