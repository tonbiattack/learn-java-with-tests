# Spring Data JPA を TDD で学ぶ

ORM を扱う章では、この教材では `Spring Data JPA` を使います。

対象コード:

- [PlayerEntity.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springdatajpa/v1/PlayerEntity.java)
- [PlayerRepository.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springdatajpa/v1/PlayerRepository.java)
- [PlayerService.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springdatajpa/v1/PlayerService.java)
- [PlayerController.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/springdatajpa/v1/PlayerController.java)
- [PlayerServiceTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerServiceTest.java)
- [PlayerRepositoryTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerRepositoryTest.java)
- [PlayerControllerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerControllerTest.java)

## 前提方針

- ORM は `Spring Data JPA` を採用する
- 永続化の実体は `Repository` に閉じ込める
- ビジネスロジックは service 層に寄せ、entity に責務を詰め込みすぎない

## ねらい

- entity / repository / service / controller の責務分離を学ぶ
- `@DataJpaTest` を使った永続化テストを学ぶ
- JPA の都合でドメイン設計が崩れやすい点を理解する

## この章で実装していること

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

今回は `@SpringBootTest` までは使っていません。まずは controller / service / repository を分けて、それぞれの責務を小さいテストで押さえることを優先しています。

## 扱っているトピック

- `@Entity`
- `JpaRepository`
- sorting
- transaction boundary
- `@Version`
- 楽観ロック

## 実装時のルール

- ORM を入れる章では `Spring Data JPA` を使う
- まず controller からではなく service の振る舞いから始める
- repository は interface として扱い、テストで役割を明確にする

## 次に広げるなら

- `@Embeddable`
- paging
- specification / query method
- `Testcontainers` を使った DB 統合テスト
