package dev.learnjavawithtests.select.v1;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

public final class UrlRacer {
    public String race(String left, String right, UrlChecker checker, Duration timeout) {
        CompletableFuture<String> leftFuture = checker.check(left).thenApply(ignored -> left);
        CompletableFuture<String> rightFuture = checker.check(right).thenApply(ignored -> right);

        try {
            return CompletableFuture.anyOf(leftFuture, rightFuture)
                    .orTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                    .thenApply(String.class::cast)
                    .join();
        } catch (CompletionException completionException) {
            throw new IllegalStateException("timed out waiting for " + left + " and " + right, completionException);
        }
    }
}

