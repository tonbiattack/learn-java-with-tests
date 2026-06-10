# learn-java-with-tests

`learn-go-with-tests` の考え方を Java に持ち込んだ、`JDK 21` 前提の TDD 学習教材です。

小さな失敗するテストを書き、最小限の実装で通し、リファクタリングする流れで Java を学びます。

## ねらい

- 自動テストを書きながら Java の基礎を学ぶ
- `red -> green -> refactor` の TDD サイクルに慣れる
- JDK 21 時代の Java で、堅い設計と小さな反復を練習する

## 前提

- `JDK 21` がインストールされていること
- ターミナルを使えること
- `if`、変数、関数のような基礎的なプログラミング経験があること

## 実行方法

このリポジトリには 2 つのテスト実行方法を用意しています。

1. Maven を使う

```powershell
mvn test
```

2. Maven なしで PowerShell スクリプトを使う

```powershell
./scripts/run-tests.ps1
```

初回実行時に `Apache Maven` を `.tools` 配下へダウンロードします。

## 目次

### Java 基礎

1. [Java をインストールする](java-fundamentals/install-java.md)
2. [Hello, World](java-fundamentals/hello-world.md)
3. [整数](java-fundamentals/integers.md)
4. [反復](java-fundamentals/iteration.md)
5. [配列とリスト](java-fundamentals/arrays-and-lists.md)
6. [クラスとインターフェース](java-fundamentals/classes-and-interfaces.md)
7. [例外と状態](java-fundamentals/exceptions.md)
8. [マップ](java-fundamentals/maps.md)
9. [依存性注入](java-fundamentals/dependency-injection.md)
10. [モック](java-fundamentals/mocking.md)
11. [並行性](java-fundamentals/concurrency.md)

### アプリケーションを作る

12. [HTTP API 入門](spring-boot/http-api.md)
13. [IO と永続化](build-an-application/io.md)

## コード配置

各章のサンプルコードは `src/main/java/dev/learnjavawithtests/...`、テストは `src/test/java/dev/learnjavawithtests/...` にあります。

`v1` はその章の最初の完成版です。今後章を増やす場合は `v2`, `v3` のように段階を足せます。

## 元ネタ

- [learn-go-with-tests](./learn-go-with-tests/README.md)
- [対応状況の星取表](coverage-matrix.md)

## Spring を使う方針

基礎章ではまず素の Java で文法と設計に集中し、その後のアプリケーション章で `Spring Boot` を使います。

`2026-06-10` 時点では、`Spring Boot 3.5.14` は公式ブログで公開されている安定版で、公式ドキュメント上も Java 17 以上が必要条件です。`JDK 21` ならこの教材の方針と噛み合います。

## 次に追加しやすい章

- `Stream`
- `Optional`
- `Spring Data JPA`
- `HTTP クライアント/サーバ`
- `Command line`
- `WebSocket`
- `並行処理`
