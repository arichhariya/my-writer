package com.task.operations;

import com.task.Operation;

public class DuplicateRemover implements Operation {
    @Override
    public String perform(String text) {
        String regex = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
        return text.replaceAll(regex, "");
    }
}
