# リフレクション

Java の `reflection` は、型を実行時に調べるための道具です。

対象コードは [ReflectiveWalker.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/reflection/v1/ReflectiveWalker.java:1)、
テストは [ReflectiveWalkerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/reflection/v1/ReflectiveWalkerTest.java:1) にあります。

## 学ぶこと

- `Field`
- `AccessibleObject`
- オブジェクトを再帰的にたどる処理

Go 版の walk 題材を、Java ではオブジェクトグラフの走査に置き換えています。

