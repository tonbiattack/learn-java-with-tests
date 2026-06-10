package dev.learnjavawithtests.time.v1;

import java.time.Duration;
import java.util.List;

public final class BlindScheduler {
    public void schedule(List<BlindLevel> levels, Scheduler scheduler, BlindAlerter alerter) {
        for (BlindLevel level : levels) {
            scheduler.waitFor(level.after());
            alerter.alert("Blind is " + level.amount());
        }
    }

    public record BlindLevel(Duration after, int amount) {
    }
}

