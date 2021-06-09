package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

    private Gum gumTest;

    @Before
    public void new_object() {
        gumTest = new Gum("Chiclets", "0.75");
    }

    @Test
    public void dispense_message_test(){
        Assert.assertEquals("\"Chew Chew, Yum!\"", gumTest.getItemDispenseMessage());
    }

    @Test
    public void to_string_test() {
        Assert.assertEquals("Chiclets 0.75", gumTest.toString());
    }
}
