# RestClient / WebClient のテスト

外部 HTTP API を呼ぶクライアント側のコードも、Spring Boot ではよく出てきます。

対象コード:

- [QuoteClient.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springrestclient/v1/QuoteClient.java)
- [Quote.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springrestclient/v1/Quote.java)
- [QuoteClientTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springrestclient/v1/QuoteClientTest.java)

## ねらい

- `RestClient` または `WebClient` をアダプタとして閉じ込める
- リトライ、タイムアウト、エラー変換をテストする
- コントローラやサービスから HTTP 詳細を分離する

## この章で実装していること

- 外部 API から quote を取得する client
- `404` をドメイン例外へ変換する
- `MockRestServiceServer` で外部 HTTP を差し替える

## 学ぶこと

- `RestClient.Builder`
- `MockRestServiceServer`
- HTTP エラーをアプリ用の例外へ変換する設計

## 方針

- 外部 API 呼び出しは adapter に閉じ込める
- service は `QuoteClient` の抽象的な結果だけを使う
- 実ネットワークには出ないテストを先に作る
