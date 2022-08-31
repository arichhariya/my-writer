package com.task;

import java.util.List;

public abstract class Writer {

    protected boolean close = false;

    public void write(String text, Operation operation) {
        operation.perform(text);
        this.write(text);
    }

    public abstract void write(String text);

    public void write(String text, List<Operation> operations) {
        operations.forEach(operation -> operation.perform(text));
        this.write(text);
    }

    public abstract String read();

    public void close() {
        this.close = true;
    }

    public void open() {
        this.close = false;
    }
}
