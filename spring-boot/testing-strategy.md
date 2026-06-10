# Spring Boot を TDD で進める

この章は **計画中** です。ここでは、Spring Boot をテスト駆動で学ぶときの進め方を整理します。

## ねらい

- `@WebMvcTest` と `@SpringBootTest` の使い分けを理解する
- ドメインロジックを Spring から切り離してテストしやすくする
- Spring 固有の便利機能に依存しすぎず、TDD の小さいサイクルを保つ

## 章で扱いたい内容

1. まずは素の Java クラスで失敗するテストを書く
2. サービス層を追加し、`@Service` は最後に付ける
3. コントローラ層は `@WebMvcTest` で薄く検証する
4. アプリ全体の結合は `@SpringBootTest` を最小限に使う
5. 外部 I/O は `Testcontainers` や fake 実装で段階的に足す

## 追加候補の章

- `Validation と例外ハンドリング`
- `RestClient / WebClient のテスト`
- `認証が入った API のテスト`
- `非同期イベントのテスト`

## 方針

- 単体テストを先に書く
- Spring の annotation は後から載せる
- controller は routing と JSON 契約に集中する
- DB やメッセージングは最後に統合する

