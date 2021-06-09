package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {

    private Chip chipTest;

    @Before
    public void new_object() {
        chipTest = new Chip("Potato Crisps", "3.05");
    }

    @Test
    public void dispense_message_test(){
        Assert.assertEquals("\"Crunch Crunch, Yum!\"", chipTest.getItemDispenseMessage());
    }

    @Test
    public void to_string_test() {
        Assert.assertEquals("Potato Crisps 3.05", chipTest.toString());
    }
}
