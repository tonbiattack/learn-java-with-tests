# Validation と例外ハンドリング

Spring Boot で API を作ると、入力検証とエラー応答はかなり早い段階で必要になります。

対象コード:

- [RegistrationController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springvalidation/v1/RegistrationController.java)
- [RegistrationService.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springvalidation/v1/RegistrationService.java)
- [ApiErrorHandler.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springvalidation/v1/ApiErrorHandler.java)
- [RegistrationControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springvalidation/v1/RegistrationControllerTest.java)
- [RegistrationServiceTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springvalidation/v1/RegistrationServiceTest.java)

## この章で実装していること

1. `POST /registrations` で登録を受け付ける
2. `@Valid` で `name` と `email` を検証する
3. 重複 email は `409 Conflict` で返す
4. validation error を JSON で整形して返す

## 学ぶこと

- `spring-boot-starter-validation`
- `@Valid`
- `@RestControllerAdvice`
- `MethodArgumentNotValidException`
- HTTP レイヤーのエラー契約をテストで固定する方法

## テストの分け方

- service は素の Java テストで重複ルールを検証する
- controller は `@WebMvcTest` で validation とレスポンス契約を検証する

