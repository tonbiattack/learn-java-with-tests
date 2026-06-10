package dev.learnjavawithtests.sync.v1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SafeCounterTest {

    @Test
    void incrementsSafelyAcrossThreads() throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.ofVirtual().start(counter::increment);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(100, counter.value());
    }
}

