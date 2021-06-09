package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

    private Candy candyTest;

    @Before
    public void new_object() {
       candyTest = new Candy("Moonpie", "1.80");
    }

    @Test
    public void dispense_message_test(){
        Assert.assertEquals("\"Munch Munch, Yum!\"", candyTest.getItemDispenseMessage());
    }

    @Test
    public void to_string_test() {
        Assert.assertEquals("Moonpie 1.80", candyTest.toString());
    }


}
