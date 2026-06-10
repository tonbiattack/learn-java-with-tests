# Hello, World

最初の章では、文字列を返す小さな関数をテストから作ります。

対象コードは [Hello.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/helloworld/v1/Hello.java)、
テストは [HelloTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/helloworld/v1/HelloTest.java) にあります。

## 最初の要件

- `hello("Chris")` は `"Hello, Chris"` を返す
- 空文字なら `"Hello, World"` を返す
- 言語を切り替えられる

## Java で見るポイント

- `class` と `static` メソッド
- `switch` 式
- `enum`
- `JUnit 5` の `@Test`

## TDD の進め方

1. 失敗するテストを書く
2. コンパイルを通す
3. テストを通す最小限の実装を書く
4. 重複を消す

この章では Go 版の流れをほぼそのまま Java に移し、文法差だけを意識すれば進められるようにしています。

