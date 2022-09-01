package com.task;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Writer {

    protected boolean closed = false;

    public abstract void write(String text);
    public abstract String read();

    public void write(String text, List<Operation> operations) {
        if (closed) return;
        AtomicReference<String> finalString = new AtomicReference<>(text);
        operations.forEach(operation -> finalString.set(operation.perform(finalString.get())));
        this.write(finalString.get());
    }

    public void write(String text, Operation operation) {
        if (closed) return;
        this.write(operation.perform(text));
    }

    public void close() {
        this.closed = true;
    }

    public void open() {
        this.closed = false;
    }
}
