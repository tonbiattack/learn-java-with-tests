package dev.learnjavawithtests.concurrency.v1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class ConcurrentWebsiteChecker {
    public Map<String, Boolean> checkWebsites(List<String> urls, WebsiteChecker checker) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Map<String, Future<Boolean>> futures = new LinkedHashMap<>();

            for (String url : urls) {
                futures.put(url, executor.submit(() -> checker.isUp(url)));
            }

            Map<String, Boolean> results = new LinkedHashMap<>();
            for (Map.Entry<String, Future<Boolean>> entry : futures.entrySet()) {
                results.put(entry.getKey(), entry.getValue().get());
            }
            return results;
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("website checking was interrupted", interrupted);
        } catch (ExecutionException executionException) {
            throw new IllegalStateException("website checking failed", executionException);
        }
    }
}

