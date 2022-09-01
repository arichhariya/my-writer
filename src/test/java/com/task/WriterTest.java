package com.task;

import com.task.operations.DuplicateRemover;
import com.task.operations.LowerCase;
import com.task.operations.StupidRemover;
import com.task.operations.UpperCase;
import com.task.writers.FileWriter;
import com.task.writers.StringWriter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WriterTest {

    @Test
    void testStringWriter() {
        Writer wr = new StringWriter();
        wr.write("HELLO WORLD");
        assertEquals("HELLO WORLD", wr.read(), "READ SHOULD RETURN WRITTEN TEXT");
        wr.write("I AM HERE");
        assertEquals("I AM HERE", wr.read(), "READ SHOULD RETURN WRITTEN TEXT");
        wr.close();
        wr.write("I am changed");
        assertEquals("I AM HERE", wr.read(), "AFTER CLOSE TEXT WRITER WILL NOT CHANGE TEXT");
        wr.open();
        List<Operation> operationList1= new ArrayList<>();
        operationList1.add(new StupidRemover());
        operationList1.add(new UpperCase());
        wr.write("I am stupid", operationList1);
        assertEquals("I AM S*****", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING OPERATIONS");
        List<Operation> operationList2= new ArrayList<>();
        operationList2.add(new StupidRemover());
        operationList2.add(new LowerCase());
        wr.write("I am stupid", operationList2);
        assertEquals("i am s*****", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING OPERATIONS");
        wr.write("I AM AM HERE", new DuplicateRemover());
        assertEquals("I AM HERE", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING DUPLICATE REMOVER OPERATIONS");
    }

    @Test
    void testFileWriter() {
        Writer wr = new FileWriter("myFile");
        wr.write("HELLO WORLD");
        assertEquals("HELLO WORLD", wr.read(), "READ SHOULD RETURN WRITTEN TEXT");
        wr.write("I AM HERE");
        assertEquals("I AM HERE", wr.read(), "READ SHOULD RETURN WRITTEN TEXT");
        wr.close();
        wr.write("I am changed");
        assertEquals("I AM HERE", wr.read(), "AFTER CLOSE TEXT WRITER WILL NOT CHANGE TEXT");
        wr.open();
        List<Operation> operationList1= new ArrayList<>();
        operationList1.add(new StupidRemover());
        operationList1.add(new UpperCase());
        wr.write("I am stupid", operationList1);
        assertEquals("I AM S*****", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING OPERATIONS");
        List<Operation> operationList2= new ArrayList<>();
        operationList2.add(new StupidRemover());
        operationList2.add(new LowerCase());
        wr.write("I am stupid", operationList2);
        assertEquals("i am s*****", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING OPERATIONS");
        wr.write("I AM AM HERE", new DuplicateRemover());
        assertEquals("I AM HERE", wr.read(), "READ SHOULD RETURN TEXT AFTER APPLYING DUPLICATE REMOVER OPERATIONS");
    }

}