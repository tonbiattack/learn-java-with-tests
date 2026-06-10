package dev.learnjavawithtests.concurrency.v1;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcurrentWebsiteCheckerTest {

    @Test
    void returnsTheStatusForEachWebsite() {
        ConcurrentWebsiteChecker checker = new ConcurrentWebsiteChecker();

        Map<String, Boolean> results = checker.checkWebsites(
                List.of("http://a.com", "http://b.com"),
                url -> !url.contains("b")
        );

        assertEquals(
                Map.of("http://a.com", true, "http://b.com", false),
                results
        );
    }

    @Test
    void checksWebsitesConcurrently() {
        ConcurrentWebsiteChecker checker = new ConcurrentWebsiteChecker();

        Instant start = Instant.now();
        checker.checkWebsites(
                List.of("http://a.com", "http://b.com", "http://c.com"),
                url -> {
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException(exception);
                    }
                    return true;
                }
        );
        Duration elapsed = Duration.between(start, Instant.now());

        assertTrue(elapsed.toMillis() < 350, "expected concurrent execution but took " + elapsed.toMillis() + "ms");
    }
}

