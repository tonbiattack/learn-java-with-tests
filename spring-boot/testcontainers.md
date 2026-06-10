# Testcontainers を使う発展章

Spring Boot と DB を本番に近い形で検証したくなったら `Testcontainers` を使います。

対象コード:

- [PlayerRepositoryPostgresContainerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerRepositoryPostgresContainerTest.java)
- [PlayerControllerPostgresContainerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/springdatajpa/v1/PlayerControllerPostgresContainerTest.java)

## ねらい

- `Spring Data JPA` のテストを実 DB に近づける
- インメモリ DB では見えにくい差分を減らす
- CI でも再現しやすい統合テストを作る

## 位置づけ

この章は [Spring Data JPA を TDD で学ぶ](spring-data-jpa.md) の続きです。H2 で成立していたテストを、PostgreSQL コンテナでも通して差分を減らします。

## この章で実装していること

- PostgreSQL コンテナで repository テストを流す
- PostgreSQL コンテナで HTTP API の結合テストを流す
- Spring Boot の `@ServiceConnection` で接続先を自動配線する

## 学ぶこと

- `@Testcontainers`
- `@Container`
- `PostgreSQLContainer`
- `@ServiceConnection`
- H2 と本番寄り DB の差を埋める考え方

## 方針

- 速いテストは引き続き H2 や mock を使う
- 重要な永続化パスだけ Testcontainers で二重に確認する
- 何でもコンテナに載せず、役割を絞る
