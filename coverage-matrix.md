# learn-go-with-tests 対応表

この表は、[learn-go-with-tests](./learn-go-with-tests/README.md) の各章に対して、現在の Java 版がどこまで実装できているかを示します。

判定基準:

- `★★★` 実装済み: 章として読めて、対応するコードとテストがある
- `★★☆` 部分実装: 近い題材はあるが、元教材の論点をまだ取り切れていない
- `☆☆☆` 未着手: まだ章もコードもない

## Go Fundamentals

| learn-go-with-tests | Java 版の状況 | 評価 | 根拠 |
|---|---|---:|---|
| Install Go | [Java をインストールする](java-fundamentals/install-java.md) | ★★★ | JDK 21 前提の導入と実行手順あり |
| Hello, world | [Hello, World](java-fundamentals/hello-world.md) | ★★★ | [Hello.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/helloworld/v1/Hello.java:1)、[HelloTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/helloworld/v1/HelloTest.java:1) |
| Integers | [整数](java-fundamentals/integers.md) | ★★★ | [Adder.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/integers/v1/Adder.java:1)、[AdderTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/integers/v1/AdderTest.java:1) |
| Iteration | [反復](java-fundamentals/iteration.md) | ★★☆ | 反復とリファクタリングはあるが、ベンチマーク章は未実装 |
| Arrays and slices | [配列とリスト](java-fundamentals/arrays-and-lists.md) | ★★☆ | `array` と `List` はあるが、varargs や coverage の掘り下げは未実装 |
| Structs, methods & interfaces | [クラスとインターフェース](java-fundamentals/classes-and-interfaces.md) | ★★☆ | `record` と `interface` はあるが、テーブル駆動テストの説明は薄い |
| Pointers & errors | [例外と状態](java-fundamentals/exceptions.md) | ★★☆ | Java 的に置き換え済みだが、Go の pointer 相当の学習軸とは少し違う |
| Maps | [マップ](java-fundamentals/maps.md) | ★★★ | [Dictionary.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/maps/v1/Dictionary.java:1)、[DictionaryTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/maps/v1/DictionaryTest.java:1) |
| Dependency Injection | [依存性注入](java-fundamentals/dependency-injection.md) | ★★★ | [Greeter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/di/v1/Greeter.java:1)、[GreeterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/di/v1/GreeterTest.java:1) |
| Mocking | [モック](java-fundamentals/mocking.md) | ★★★ | [Countdown.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/mocking/v1/Countdown.java:1)、[CountdownTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/mocking/v1/CountdownTest.java:1) |
| Concurrency | [並行性](java-fundamentals/concurrency.md) | ★★★ | [ConcurrentWebsiteChecker.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/concurrency/v1/ConcurrentWebsiteChecker.java:1)、[ConcurrentWebsiteCheckerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/concurrency/v1/ConcurrentWebsiteCheckerTest.java:1) |
| Select | なし | ☆☆☆ | Java 対応方針も未整理 |
| Reflection | なし | ☆☆☆ | 未着手 |
| Sync | なし | ☆☆☆ | 未着手 |
| Context | なし | ☆☆☆ | 未着手 |
| Intro to property based tests | なし | ☆☆☆ | 未着手 |
| Maths | なし | ☆☆☆ | 未着手 |

## Build an application

| learn-go-with-tests | Java 版の状況 | 評価 | 根拠 |
|---|---|---:|---|
| HTTP server | [HTTP API 入門](spring-boot/http-api.md) | ★★★ | Spring Boot で HTTP エンドポイントと MVC テストを実装済み |
| JSON, routing and embedding | [HTTP API 入門](spring-boot/http-api.md) | ★★☆ | JSON と routing はあるが、埋め込み相当は未実装 |
| IO and sorting | [IO と永続化](build-an-application/io.md) | ★★★ | [FilePlayerStore.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/io/v1/FilePlayerStore.java:1)、[FilePlayerStoreTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/io/v1/FilePlayerStoreTest.java:1) |
| Command line & project structure | なし | ☆☆☆ | 未着手 |
| Time | なし | ☆☆☆ | 未着手 |
| WebSockets | なし | ☆☆☆ | 未着手 |

## Questions and answers

| learn-go-with-tests | Java 版の状況 | 評価 | 根拠 |
|---|---|---:|---|
| OS exec | なし | ☆☆☆ | 未着手 |
| Error types | [例外と状態](java-fundamentals/exceptions.md) | ★★☆ | カスタム例外はあるが、独立した設計論としてはまだ弱い |
| Context-aware Reader | なし | ☆☆☆ | 未着手 |
| Revisiting HTTP Handlers | なし | ★★☆ | `MockMvc` による HTTP テストの入口はあるが、章としての設計論は未実装 |

## 集計

| 区分 | 件数 |
|---|---:|
| `★★★` 実装済み | 10 |
| `★★☆` 部分実装 | 6 |
| `☆☆☆` 未着手 | 11 |

`learn-go-with-tests` の章ベースでは、現状は「基礎中盤と IO まで」が Java 化できている段階です。

次に埋めるなら、`Select`、`Reflection`、`Sync`、`Command line`、`WebSockets` の順で広げると、Go 版の後半に近づきます。
