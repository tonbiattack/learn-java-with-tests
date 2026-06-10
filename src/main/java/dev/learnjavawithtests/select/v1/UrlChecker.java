package dev.learnjavawithtests.select.v1;

import java.util.concurrent.CompletableFuture;

@FunctionalInterface
public interface UrlChecker {
    CompletableFuture<Void> check(String url);
}

