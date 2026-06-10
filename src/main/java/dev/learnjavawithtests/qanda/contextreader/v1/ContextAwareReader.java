package dev.learnjavawithtests.qanda.contextreader.v1;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ContextAwareReader extends Reader {
    private final Reader delegate;
    private final AtomicBoolean cancelled;

    public ContextAwareReader(Reader delegate, AtomicBoolean cancelled) {
        this.delegate = delegate;
        this.cancelled = cancelled;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (cancelled.get()) {
            throw new IOException("read cancelled");
        }
        return delegate.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }
}

