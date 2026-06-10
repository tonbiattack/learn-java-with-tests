package dev.learnjavawithtests.sync.v1;

public final class SafeCounter {
    private int value;

    public synchronized void increment() {
        value++;
    }

    public synchronized int value() {
        return value;
    }
}

