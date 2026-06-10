# 認証が入った API のテスト

この章では、Spring Security を入れた API を小さくテスト駆動で組み立てます。

`learn-go-with-tests` の HTTP handler の発展として、Java / Spring Boot では「認証と権限」を `MockMvc` で固定する練習に置き換えます。

## ねらい

- 認証前提の API 契約を `MockMvc` で固定する
- 未認証の `401` と権限不足の `403` を区別する
- 認可ルールを `SecurityFilterChain` に集める
- ビジネスロジックを Controller や Security 設定から分離する

## 今回作る API

- `GET /security/profile`
  - 未認証なら `401`
  - 認証済みならユーザー名と権限を返す
- `POST /security/admin/reports`
  - `ADMIN` 権限がなければ `403`
  - `ADMIN` 権限があれば `201`

## まず失敗するテストを書く

[SecureApiControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springsecurity/v1/SecureApiControllerTest.java:1) では、次の 4 つを最初に固定します。

- 未認証のプロフィール取得は `401`
- 認証済みユーザーはプロフィールを取得できる
- 一般ユーザーは管理 API で `403`
- 管理者ユーザーは管理 API を実行できる

`MockMvc` に対して `.with(user(...))` や `.with(httpBasic(...))` を付けると、Security を含む HTTP 契約をコントローラテストで直接確認できます。

## 最小実装

セキュリティ設定は [SecurityConfiguration.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/SecurityConfiguration.java:1) にまとめます。

```java
authorize.requestMatchers("/security/profile").authenticated();
authorize.requestMatchers("/security/admin/**").hasRole("ADMIN");
authorize.anyRequest().permitAll();
```

この教材では既存の章を壊さないため、CSRF は無効化しています。フォームベースではなく、ステートレスな JSON API の最小構成として扱っています。

## 認証と業務ロジックを分ける

Controller は認証情報を直接処理し込みません。

- [ProfileService.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/ProfileService.java:1)
- [AdminReportService.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/AdminReportService.java:1)

Controller の責務は薄く保ちます。

- `Authentication` を受け取る
- リクエストをサービスへ渡す
- HTTP ステータスを返す

## 実装クラス

- [SecureApiController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/SecureApiController.java:1)
- [SecurityConfiguration.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springsecurity/v1/SecurityConfiguration.java:1)
- [SecureApiControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springsecurity/v1/SecureApiControllerTest.java:1)

## 学びどころ

- Spring Security を入れると、アプリ全体に影響が及ぶ
- そのため、認可ルールを限定した `SecurityFilterChain` を最初に明示する価値が高い
- `401` と `403` は意味が違うので、テストで分けて固定する
- Security のテストでも、Controller の外へ業務ロジックを逃がしておくと見通しが良い

## 次に広げるなら

- `@PreAuthorize` を使ったメソッド単位の認可
- JWT ベースの Resource Server テスト
- CSRF を有効にしたフォーム送信やブラウザ向け API のテスト
