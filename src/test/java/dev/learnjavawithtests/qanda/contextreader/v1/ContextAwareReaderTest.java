package dev.learnjavawithtests.qanda.contextreader.v1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContextAwareReaderTest {

    @Test
    void readsNormallyWhenNotCancelled() throws IOException {
        ContextAwareReader reader = new ContextAwareReader(new StringReader("hello"), new AtomicBoolean(false));
        char[] buffer = new char[5];

        int read = reader.read(buffer, 0, 5);

        assertEquals(5, read);
        assertEquals("hello", new String(buffer));
    }

    @Test
    void failsFastWhenCancelled() {
        ContextAwareReader reader = new ContextAwareReader(new StringReader("hello"), new AtomicBoolean(true));

        assertThrows(IOException.class, () -> reader.read(new char[5], 0, 5));
    }
}

