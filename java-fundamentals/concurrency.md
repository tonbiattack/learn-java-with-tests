# 並行性

JDK 21 では virtual threads が使えるので、並行処理の入口をかなり素直に書けます。

対象コードは [ConcurrentWebsiteChecker.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/concurrency/v1/ConcurrentWebsiteChecker.java:1)、
テストは [ConcurrentWebsiteCheckerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/concurrency/v1/ConcurrentWebsiteCheckerTest.java:1) にあります。

## 学ぶこと

- `ExecutorService`
- `Executors.newVirtualThreadPerTaskExecutor()`
- 並行に集めた結果を `Map` に戻す

Go の goroutine に相当する体験を、Java では task と executor で学びます。

