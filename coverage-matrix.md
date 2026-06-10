# learn-go-with-tests 対応表

この表は、[learn-go-with-tests](./learn-go-with-tests/README.md) の各章に対して、現在の Java 版がどこまで実装できているかを示します。

`spring-boot/` 配下には今後の発展章の設計メモもありますが、この表では **実装とテストがあるものだけ** を集計対象にしています。

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
| Select | [Select](java-fundamentals/select.md) | ★★★ | [UrlRacer.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/select/v1/UrlRacer.java:1)、[UrlRacerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/select/v1/UrlRacerTest.java:1) |
| Reflection | [リフレクション](java-fundamentals/reflection.md) | ★★★ | [ReflectiveWalker.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/reflection/v1/ReflectiveWalker.java:1)、[ReflectiveWalkerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/reflection/v1/ReflectiveWalkerTest.java:1) |
| Sync | [同期](java-fundamentals/sync.md) | ★★★ | [SafeCounter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/sync/v1/SafeCounter.java:1)、[SafeCounterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/sync/v1/SafeCounterTest.java:1) |
| Context | [Context](java-fundamentals/context.md) | ★★★ | [CancellableCounter.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/context/v1/CancellableCounter.java:1)、[CancellableCounterTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/context/v1/CancellableCounterTest.java:1) |
| Intro to property based tests | [プロパティベーステスト入門](java-fundamentals/roman-numerals.md) | ★★★ | [RomanNumerals.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/romannumerals/v1/RomanNumerals.java:1)、[RomanNumeralsTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/romannumerals/v1/RomanNumeralsTest.java:1) |
| Maths | [Maths](java-fundamentals/maths.md) | ★★★ | [ClockSvgRenderer.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/maths/v1/ClockSvgRenderer.java:1)、[ClockSvgRendererTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/maths/v1/ClockSvgRendererTest.java:1) |

## Build an application

| learn-go-with-tests | Java 版の状況 | 評価 | 根拠 |
|---|---|---:|---|
| HTTP server | [HTTP API 入門](spring-boot/http-api.md) | ★★★ | Spring Boot で HTTP エンドポイントと MVC テストを実装済み |
| JSON, routing and embedding | [HTTP API 入門](spring-boot/http-api.md) | ★★☆ | JSON と routing はあるが、埋め込み相当は未実装 |
| IO and sorting | [IO と永続化](build-an-application/io.md) | ★★★ | [FilePlayerStore.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/io/v1/FilePlayerStore.java:1)、[FilePlayerStoreTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/io/v1/FilePlayerStoreTest.java:1) |
| Command line & project structure | [コマンドライン](build-an-application/command-line.md) | ★★★ | [LeagueCli.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/commandline/v1/LeagueCli.java:1)、[LeagueCliTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/commandline/v1/LeagueCliTest.java:1) |
| Time | [Time](build-an-application/time.md) | ★★★ | [BlindScheduler.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/time/v1/BlindScheduler.java:1)、[BlindSchedulerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/time/v1/BlindSchedulerTest.java:1) |
| WebSockets | [WebSockets](build-an-application/websockets.md) | ★★★ | [GameWebSocketHandler.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/websockets/v1/GameWebSocketHandler.java:1)、[GameWebSocketHandlerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/websockets/v1/GameWebSocketHandlerTest.java:1) |

## Questions and answers

| learn-go-with-tests | Java 版の状況 | 評価 | 根拠 |
|---|---|---:|---|
| OS exec | [OS exec](questions-and-answers/os-exec.md) | ★★★ | [GitVersionFinder.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/qanda/osexec/v1/GitVersionFinder.java:1)、[GitVersionFinderTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/qanda/osexec/v1/GitVersionFinderTest.java:1) |
| Error types | [例外と状態](java-fundamentals/exceptions.md) | ★★☆ | カスタム例外はあるが、独立した設計論としてはまだ弱い |
| Context-aware Reader | [Context-aware Reader](questions-and-answers/context-aware-reader.md) | ★★★ | [ContextAwareReader.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/qanda/contextreader/v1/ContextAwareReader.java:1)、[ContextAwareReaderTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/qanda/contextreader/v1/ContextAwareReaderTest.java:1) |
| Revisiting HTTP Handlers | なし | ★★☆ | `MockMvc` による HTTP テストの入口はあるが、章としての設計論は未実装 |

## 集計

| 区分 | 件数 |
|---|---:|
| `★★★` 実装済み | 21 |
| `★★☆` 部分実装 | 6 |
| `☆☆☆` 未着手 | 0 |

`learn-go-with-tests` の章ベースでは、現状は「基礎後半とアプリケーション中盤まで」が Java 化できている段階です。

元の `learn-go-with-tests` で未着手だった章は一通り埋まり、残っているのは Java 向けに意図的に再構成した `★★☆` の章です。

## Spring Boot 独自の発展章

以下は `learn-go-with-tests` の原本には直接対応しないものの、Java / Spring Boot 教材として追加している章です。

| 章 | 状況 | 根拠 |
|---|---:|---|
| [Spring Data JPA を TDD で学ぶ](spring-boot/spring-data-jpa.md) | ★★★ | [PlayerController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springdatajpa/v1/PlayerController.java:1)、[PlayerRepositoryTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerRepositoryTest.java:1) |
| [Testcontainers を使う発展章](spring-boot/testcontainers.md) | ★★★ | [PlayerRepositoryPostgresContainerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerRepositoryPostgresContainerTest.java:1)、[PlayerControllerPostgresContainerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerControllerPostgresContainerTest.java:1) |
| [Validation と例外ハンドリング](spring-boot/validation-and-exception-handling.md) | ★★★ | [RegistrationController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springvalidation/v1/RegistrationController.java:1)、[RegistrationControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springvalidation/v1/RegistrationControllerTest.java:1) |
| [RestClient / WebClient のテスト](spring-boot/rest-client.md) | ★★★ | [QuoteClient.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springrestclient/v1/QuoteClient.java:1)、[QuoteClientTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springrestclient/v1/QuoteClientTest.java:1) |
| [認証が入った API のテスト](spring-boot/security.md) | ★★★ | [SecureApiController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/SecureApiController.java:1)、[SecureApiControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springsecurity/v1/SecureApiControllerTest.java:1) |
| [非同期イベントのテスト](spring-boot/async-events.md) | ☆☆☆ | ドキュメントのみ |
