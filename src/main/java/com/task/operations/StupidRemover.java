package com.task.operations;

import com.task.Operation;

public class StupidRemover implements Operation {
    @Override
    public String perform(String text) {
        return text.replaceAll("stupid","s*****");
    }
}
