package dev.learnjavawithtests.di.v1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {

    @Test
    void writesGreetingToTheProvidedWriter() throws IOException {
        StringWriter writer = new StringWriter();

        new Greeter().greet(writer, "Chris");

        assertEquals("Hello, Chris", writer.toString());
    }
}

