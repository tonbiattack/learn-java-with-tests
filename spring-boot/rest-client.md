# RestClient / WebClient のテスト

この章は **計画中** です。外部 HTTP API を呼ぶクライアント側のコードも、Spring Boot ではよく出てきます。

## ねらい

- `RestClient` または `WebClient` をアダプタとして閉じ込める
- リトライ、タイムアウト、エラー変換をテストする
- コントローラやサービスから HTTP 詳細を分離する

## 章で扱いたい内容

- 外部 API からユーザー情報を取得する client
- 404 / 500 の変換
- `MockRestServiceServer` か fake HTTP server を使ったテスト

