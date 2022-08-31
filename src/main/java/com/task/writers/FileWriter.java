package com.task.writers;

import com.task.Writer;

public class FileWriter extends Writer {
    private String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String text) {

    }

    @Override
    public String read() {
        return null;
    }
}
