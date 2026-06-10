# 依存性注入

依存性注入は、外界への書き込みを引数として受け取り、ロジックをテストしやすくする基本技法です。

対象コードは [Greeter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/di/v1/Greeter.java:1)、
テストは [GreeterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/di/v1/GreeterTest.java:1) にあります。

## 学ぶこと

- `Writer` インターフェースの利用
- 出力先の差し替え
- 副作用とドメインロジックの分離

Spring を使わなくても、Java 標準ライブラリだけで DI の感覚は十分練習できます。

