package com.task.operations;

import com.task.Operation;

public class LowerCase implements Operation {
    @Override
    public String perform(String text) {
        return text.toLowerCase();
    }
}
