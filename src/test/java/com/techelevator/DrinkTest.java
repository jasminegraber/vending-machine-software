package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

    private Drink drinkTest;

    @Before
    public void new_object() {
        drinkTest = new Drink("Mountain Melter", "1.50");
    }

    @Test
    public void dispense_message_test(){
        Assert.assertEquals("\"Glug Glug, Yum!\"", drinkTest.getItemDispenseMessage());
    }

    @Test
    public void to_string_test() {
        Assert.assertEquals("Mountain Melter 1.50", drinkTest.toString());
    }

}
