package dev.learnjavawithtests.time.v1;

import java.time.Duration;

public interface Scheduler {
    void waitFor(Duration duration);
}

