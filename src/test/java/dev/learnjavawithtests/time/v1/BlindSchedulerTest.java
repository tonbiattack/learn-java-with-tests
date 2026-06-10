package dev.learnjavawithtests.time.v1;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlindSchedulerTest {

    @Test
    void waitsAndAlertsForEachBlindLevel() {
        SpyScheduler scheduler = new SpyScheduler();
        SpyAlerter alerter = new SpyAlerter();
        BlindScheduler blindScheduler = new BlindScheduler();

        blindScheduler.schedule(List.of(
                new BlindScheduler.BlindLevel(Duration.ofMinutes(5), 100),
                new BlindScheduler.BlindLevel(Duration.ofMinutes(10), 200)
        ), scheduler, alerter);

        assertEquals(List.of(Duration.ofMinutes(5), Duration.ofMinutes(10)), scheduler.waited);
        assertEquals(List.of("Blind is 100", "Blind is 200"), alerter.messages);
    }

    private static final class SpyScheduler implements Scheduler {
        private final List<Duration> waited = new ArrayList<>();

        @Override
        public void waitFor(Duration duration) {
            waited.add(duration);
        }
    }

    private static final class SpyAlerter implements BlindAlerter {
        private final List<String> messages = new ArrayList<>();

        @Override
        public void alert(String message) {
            messages.add(message);
        }
    }
}

