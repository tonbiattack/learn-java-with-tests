# HTTP API 入門

ここからは `Spring Boot` を使って、HTTP API をテスト駆動で作ります。

対象コード:

- [LearnJavaWithTestsApplication.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/LearnJavaWithTestsApplication.java)
- [GreetingController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springhttp/v1/GreetingController.java)
- [GreetingService.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springhttp/v1/GreetingService.java)
- [GreetingControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springhttp/v1/GreetingControllerTest.java)

## 最初の要件

- `GET /hello?name=Chris` で挨拶を返す
- `name` が無ければ `World` を使う
- JSON を返す

## 学ぶこと

- `@RestController`
- `@GetMapping`
- `@RequestParam`
- `@WebMvcTest`
- HTTP レイヤーとドメインロジックの分離

## テストの分け方

この章では 2 種類のテストを使っています。

1. `GreetingServiceTest`
   素の Java オブジェクトとして振る舞いを確認する
2. `GreetingControllerTest`
   `MockMvc` で HTTP レイヤーを確認する

Spring を使っていても、ロジックの中心は薄いクラスに閉じ込める方が TDD しやすい、という感覚を掴むのが狙いです。

