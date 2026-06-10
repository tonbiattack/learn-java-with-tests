package dev.learnjavawithtests.context.v1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

public final class CancellableCounter {
    public void countTo(int max, AtomicBoolean cancelled, IntConsumer consumer) {
        for (int number = 1; number <= max; number++) {
            if (cancelled.get()) {
                return;
            }
            consumer.accept(number);
        }
    }
}

