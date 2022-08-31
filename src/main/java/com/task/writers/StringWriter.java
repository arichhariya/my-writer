package com.task.writers;

import com.task.Writer;

public class StringWriter extends Writer {

    private String string;


    @Override
    public void write(String text) {
        if (closed) return;
        string = string.concat(text);
    }

    @Override
    public String read() {
        return string;
    }
}
