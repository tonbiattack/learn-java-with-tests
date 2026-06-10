# Select

Go の `select` に近い題材として、複数の非同期処理のうち最初に終わったものを採用する処理を作ります。

対象コードは [UrlRacer.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/select/v1/UrlRacer.java:1)、
テストは [UrlRacerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/select/v1/UrlRacerTest.java:1) にあります。

## 学ぶこと

- `CompletableFuture`
- タイムアウト
- 先に終わった結果を採用する設計

Java では `select` 構文はありませんが、非同期結果の競争は十分表現できます。

