package com.task.writers;

import com.task.Writer;

public class StringWriter extends Writer {

    private String stringName;

    public StringWriter(String stringName) {
        this.stringName = stringName;
    }


    @Override
    public void write(String text) {

    }

    @Override
    public String read() {
        return null;
    }
}
