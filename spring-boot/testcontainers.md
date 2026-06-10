# Testcontainers を使う発展章

この章は **計画中** です。Spring Boot と DB を本番に近い形で検証したくなったら `Testcontainers` を使います。

## ねらい

- `Spring Data JPA` のテストを実 DB に近づける
- インメモリ DB では見えにくい差分を減らす
- CI でも再現しやすい統合テストを作る

## 位置づけ

この章は [Spring Data JPA を TDD で学ぶ](spring-data-jpa.md) の次に置く想定です。

## 章で扱いたい内容

- PostgreSQL コンテナで repository テストを流す
- migration を含んだ起動テストを作る
- `@DynamicPropertySource` で接続先を差し替える
- 遅いテストをどこまで増やすべきか整理する

