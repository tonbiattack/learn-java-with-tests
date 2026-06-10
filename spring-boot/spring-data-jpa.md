# Spring Data JPA を TDD で学ぶ

この章は **計画中** です。ORM を扱う場合、この教材では `Spring Data JPA` を使います。

## 前提方針

- ORM は `Spring Data JPA` を採用する
- 永続化の実体は `Repository` に閉じ込める
- ビジネスロジックは service 層に寄せ、entity に責務を詰め込みすぎない

## ねらい

- entity / repository / service / controller の責務分離を学ぶ
- `@DataJpaTest` を使った永続化テストを学ぶ
- JPA の都合でドメイン設計が崩れやすい点を理解する

## 章の候補構成

1. `POST /players` で player を作る
2. `GET /players/{id}` で 1 件取得する
3. `GET /players` で一覧を返す
4. `PATCH /players/{id}` で更新する
5. `DELETE /players/{id}` で削除する

## テストの分け方

### 1. サービスの単体テスト

- Java オブジェクトとしてユースケースを検証する
- repository は fake か mock に置き換える

### 2. `@DataJpaTest`

- repository のクエリや永続化マッピングを検証する
- まずはインメモリ DB、必要になったら `Testcontainers` へ進む

### 3. `@WebMvcTest`

- HTTP 契約だけを検証する
- service を mock に差し替える

### 4. `@SpringBootTest`

- 重要な結合パスだけに限定する
- 何でも全部ここでテストしない

## 扱いたいトピック

- `@Entity`
- `@Embeddable`
- `JpaRepository`
- paging / sorting
- transaction boundary
- N+1 の入り口
- 楽観ロック

## 実装時のルール

- ORM を入れる章では `Spring Data JPA` を使う
- まず controller からではなく service の振る舞いから始める
- repository は interface として扱い、テストで役割を明確にする

