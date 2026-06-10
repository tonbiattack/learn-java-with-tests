package dev.learnjavawithtests.mocking.v1;

public final class Countdown {
    private final Sleeper sleeper;
    private final LineWriter writer;

    public Countdown(Sleeper sleeper, LineWriter writer) {
        this.sleeper = sleeper;
        this.writer = writer;
    }

    public void start() {
        for (int i = 3; i > 0; i--) {
            writer.writeLine(Integer.toString(i));
            sleeper.sleep();
        }
        writer.writeLine("Go!");
    }
}

