# プロパティベーステスト概要

小さな例ベースのテストだけでなく、性質そのものを検証するテストも有効です。

対象コードは [RomanNumerals.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/romannumerals/v1/RomanNumerals.java:1)、
テストは [RomanNumeralsTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/romannumerals/v1/RomanNumeralsTest.java:1) にあります。

## 学ぶこと

- 例ベースのテスト
- round-trip property
- `jqwik`

この章では `toRoman` と `fromRoman` が互いに逆変換になる、という性質を確認します。

