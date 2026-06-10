# 同期

複数スレッドから共有状態を触るときは、同期が必要です。

対象コードは [SafeCounter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/sync/v1/SafeCounter.java:1)、
テストは [SafeCounterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/sync/v1/SafeCounterTest.java:1) にあります。

## 学ぶこと

- `synchronized`
- 共有可変状態
- 並行テスト

Go の `Mutex` に近い練習を、Java の同期機構で行います。

