# コンテキスト認識リーダー

読み込み途中でキャンセルしたい処理を、`Reader` ラッパーとして表現します。

対象コードは [ContextAwareReader.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/qanda/contextreader/v1/ContextAwareReader.java:1)、
テストは [ContextAwareReaderTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/qanda/contextreader/v1/ContextAwareReaderTest.java:1) にあります。

## 学ぶこと

- `Reader` デコレータ
- キャンセル検知
- 途中停止時の振る舞いをテストする方法

