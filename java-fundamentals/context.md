# Context

Java では Go の `context.Context` そのものはありませんが、キャンセル可能な処理という考え方は重要です。

対象コードは [CancellableCounter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/context/v1/CancellableCounter.java:1)、
テストは [CancellableCounterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/context/v1/CancellableCounterTest.java:1) にあります。

## 学ぶこと

- キャンセル可能なループ
- `AtomicBoolean`
- 長時間処理が停止できることをテストする方法

