# OS 実行

OS コマンドに依存する処理も、境界を分ければテストできます。

対象コードは [GitVersionFinder.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/qanda/osexec/v1/GitVersionFinder.java:1)、
テストは [GitVersionFinderTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/qanda/osexec/v1/GitVersionFinderTest.java:1) にあります。

## 学ぶこと

- `ProcessBuilder` の境界抽象化
- コマンド実行結果のパース
- fake 実装で OS 依存を消す方法

