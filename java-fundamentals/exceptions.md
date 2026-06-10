# 例外と状態

状態を持つオブジェクトと、失敗をどう表現するかを学びます。

対象コードは [Wallet.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/wallet/v1/Wallet.java)、
[Money.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/wallet/v1/Money.java)、
テストは [WalletTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/wallet/v1/WalletTest.java) にあります。

## 学ぶこと

- カスタム例外
- 値オブジェクト
- 状態変更のテスト

Go 版の「pointers and errors」に近い位置づけですが、Java では参照・例外・不変オブジェクトを軸に組み立てています。

