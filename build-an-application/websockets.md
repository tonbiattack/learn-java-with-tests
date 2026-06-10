# WebSockets

双方向通信の入口として、Spring の `TextWebSocketHandler` を使います。

対象コードは [GameWebSocketHandler.java](/C:/apps/learn-java-with-tests/src/main/java/dev/learnjavawithtests/websockets/v1/GameWebSocketHandler.java:1)、
テストは [GameWebSocketHandlerTest.java](/C:/apps/learn-java-with-tests/src/test/java/dev/learnjavawithtests/websockets/v1/GameWebSocketHandlerTest.java:1) にあります。

## 学ぶこと

- `TextWebSocketHandler`
- 接続時に状態を push する設計
- メッセージ受信時の処理

今回は最小構成として、接続時に順位表を送り、テキストメッセージで勝者名を受け取って記録します。

