package dev.learnjavawithtests.di.v1;

import java.io.IOException;
import java.io.Writer;

public final class Greeter {
    public void greet(Writer writer, String name) throws IOException {
        writer.write("Hello, " + name);
    }
}

