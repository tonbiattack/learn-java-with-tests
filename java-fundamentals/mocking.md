# モック

依存先を差し替えられるようになると、次はその呼ばれ方を検証できます。

対象コードは [Countdown.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/mocking/v1/Countdown.java:1)、
テストは [CountdownTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/mocking/v1/CountdownTest.java:1) にあります。

## 学ぶこと

- テストダブル
- スパイ
- 呼び出し順の検証

Java では Mockito を入れる前に、自前の小さなスパイで何を確かめたいのかを理解しておく方が筋が良いです。

