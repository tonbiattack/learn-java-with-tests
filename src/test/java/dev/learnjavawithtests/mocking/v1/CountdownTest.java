package dev.learnjavawithtests.mocking.v1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountdownTest {

    @Test
    void printsTheCountdown() {
        SpyCountdownOperations spy = new SpyCountdownOperations();

        new Countdown(spy, spy).start();

        assertEquals(List.of("3", "2", "1", "Go!"), spy.writtenLines);
    }

    @Test
    void sleepsBetweenEachPrintedNumber() {
        SpyCountdownOperations spy = new SpyCountdownOperations();

        new Countdown(spy, spy).start();

        assertEquals(
                List.of("write", "sleep", "write", "sleep", "write", "sleep", "write"),
                spy.calls
        );
    }

    private static final class SpyCountdownOperations implements Sleeper, LineWriter {
        private final List<String> calls = new ArrayList<>();
        private final List<String> writtenLines = new ArrayList<>();

        @Override
        public void sleep() {
            calls.add("sleep");
        }

        @Override
        public void writeLine(String value) {
            calls.add("write");
            writtenLines.add(value);
        }
    }
}

