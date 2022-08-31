package com.task.operations;

import com.task.Operation;

public class UpperCase implements Operation {
    @Override
    public String perform(String text) {
        return text.toUpperCase();
    }
}
