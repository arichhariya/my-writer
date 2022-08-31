package com.task.writers;

import com.task.Writer;
import com.task.exception.WriterException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileWriter extends Writer {
    private final String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String text) {
        if(closed) return;
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileName, true))) {
            bw.append(text);
        } catch (IOException e) {
            throw new WriterException("ERROR WHILE WRITING");
        }

    }

    @Override
    public String read() {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[10];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.read(buffer) != -1) {
                sb.append(new String(buffer));
            }
        } catch (IOException e) {
            throw new WriterException("ERROR WHILE READING");
        }
        return sb.toString();
    }
}
