package dev.learnjavawithtests.concurrency.v1;

@FunctionalInterface
public interface WebsiteChecker {
    boolean isUp(String url);
}

