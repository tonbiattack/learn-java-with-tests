# Java をインストールする

この教材は `JDK 21` を前提にしています。

まずは以下を確認してください。

```powershell
java -version
javac -version
```

`21.x` が表示されれば準備完了です。

`java` は実行環境、`javac` はコンパイラです。TDD ではこの 2 つを高頻度で使います。

## テストを走らせる

Maven が入っていれば次で十分です。

```powershell
mvn test
```

Maven がなくても、このリポジトリでは次で実行できます。

```powershell
./scripts/run-tests.ps1
```

## ここで大事なこと

- テストは手で確認する代わりの高速フィードバックです
- IDE の Run ボタンより先に、ターミナルから 1 回は実行できる状態にします
- コンパイルエラーも重要なフィードバックです

