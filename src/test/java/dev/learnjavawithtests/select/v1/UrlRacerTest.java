package dev.learnjavawithtests.select.v1;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UrlRacerTest {

    @Test
    void returnsTheFasterUrl() {
        UrlRacer racer = new UrlRacer();
        UrlChecker checker = url -> CompletableFuture.runAsync(() -> sleep(url.contains("fast") ? 10 : 80));

        String winner = racer.race("http://slow.example", "http://fast.example", checker, Duration.ofMillis(200));

        assertEquals("http://fast.example", winner);
    }

    @Test
    void failsIfNeitherRespondsInTime() {
        UrlRacer racer = new UrlRacer();
        UrlChecker checker = url -> CompletableFuture.runAsync(() -> sleep(100));

        assertThrows(
                IllegalStateException.class,
                () -> racer.race("http://a.example", "http://b.example", checker, Duration.ofMillis(20))
        );
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(interruptedException);
        }
    }
}

