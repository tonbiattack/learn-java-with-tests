package dev.learnjavawithtests.websockets.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public final class GameWebSocketHandler extends TextWebSocketHandler {
    private final PlayerStore playerStore;
    private final ObjectMapper objectMapper;

    public GameWebSocketHandler(PlayerStore playerStore, ObjectMapper objectMapper) {
        this.playerStore = playerStore;
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        session.sendMessage(new TextMessage(toJson(playerStore.leagueTable())));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        playerStore.recordWin(message.getPayload());
    }

    private String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
