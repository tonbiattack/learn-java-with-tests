package dev.learnjavawithtests.context.v1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CancellableCounterTest {

    @Test
    void stopsWhenCancellationIsRequested() {
        CancellableCounter counter = new CancellableCounter();
        AtomicBoolean cancelled = new AtomicBoolean(false);
        List<Integer> seen = new ArrayList<>();

        counter.countTo(5, cancelled, value -> {
            seen.add(value);
            if (value == 2) {
                cancelled.set(true);
            }
        });

        assertEquals(List.of(1, 2), seen);
    }
}

