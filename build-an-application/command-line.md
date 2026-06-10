# コマンドライン

HTTP の外にも、同じドメインロジックを CLI から使えるようにします。

対象コードは [LeagueCli.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/commandline/v1/LeagueCli.java:1)、
テストは [LeagueCliTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/commandline/v1/LeagueCliTest.java:1) にあります。

## 学ぶこと

- `Reader` / `Writer`
- 入力のパース
- ユースケースと入出力の分離

`league` と入力したら順位表を返し、`Chris wins` のような入力で勝利数を更新します。

