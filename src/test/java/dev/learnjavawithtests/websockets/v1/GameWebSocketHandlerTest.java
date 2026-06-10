package dev.learnjavawithtests.websockets.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.learnjavawithtests.io.v1.LeagueEntry;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameWebSocketHandlerTest {

    @Test
    void sendsTheLeagueWhenAClientConnects() throws Exception {
        SpyPlayerStore playerStore = new SpyPlayerStore();
        playerStore.league = List.of(new LeagueEntry("Pepper", 2));
        SpySession session = new SpySession();

        new GameWebSocketHandler(playerStore, new ObjectMapper()).afterConnectionEstablished(session);

        assertEquals(List.of("[{\"name\":\"Pepper\",\"wins\":2}]"), session.messages);
    }

    @Test
    void recordsTheWinnerWhenAMessageArrives() throws Exception {
        SpyPlayerStore playerStore = new SpyPlayerStore();
        SpySession session = new SpySession();
        GameWebSocketHandler handler = new GameWebSocketHandler(playerStore, new ObjectMapper());

        handler.handleMessage(session, new TextMessage("Chris"));

        assertEquals(List.of("Chris"), playerStore.recordedWins);
    }

    private static final class SpyPlayerStore implements PlayerStore {
        private final List<String> recordedWins = new ArrayList<>();
        private List<LeagueEntry> league = List.of();

        @Override
        public void recordWin(String playerName) {
            recordedWins.add(playerName);
        }

        @Override
        public List<LeagueEntry> leagueTable() {
            return league;
        }
    }

    private static final class SpySession implements WebSocketSession {
        private final List<String> messages = new ArrayList<>();

        @Override
        public String getId() {
            return "1";
        }

        @Override
        public URI getUri() {
            return URI.create("ws://localhost/game");
        }

        @Override
        public HttpHeaders getHandshakeHeaders() {
            return HttpHeaders.EMPTY;
        }

        @Override
        public Map<String, Object> getAttributes() {
            return Map.of();
        }

        @Override
        public Principal getPrincipal() {
            return null;
        }

        @Override
        public InetSocketAddress getLocalAddress() {
            return null;
        }

        @Override
        public InetSocketAddress getRemoteAddress() {
            return null;
        }

        @Override
        public String getAcceptedProtocol() {
            return null;
        }

        @Override
        public void setTextMessageSizeLimit(int messageSizeLimit) {
        }

        @Override
        public int getTextMessageSizeLimit() {
            return 0;
        }

        @Override
        public void setBinaryMessageSizeLimit(int messageSizeLimit) {
        }

        @Override
        public int getBinaryMessageSizeLimit() {
            return 0;
        }

        @Override
        public List<WebSocketExtension> getExtensions() {
            return List.of();
        }

        @Override
        public boolean isOpen() {
            return true;
        }

        @Override
        public void sendMessage(WebSocketMessage<?> message) {
            messages.add(((TextMessage) message).getPayload());
        }

        @Override
        public void close() {
        }

        @Override
        public void close(org.springframework.web.socket.CloseStatus status) {
        }
    }
}
