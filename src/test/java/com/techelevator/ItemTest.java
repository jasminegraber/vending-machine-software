package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ItemTest {

    private Item itemTest;

    @Before
    public void new_object() {
        itemTest = new Item("U-Chews", "0.85") {
            @Override
            public String getItemDispenseMessage() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }
        };
    }

    @Test
    public void price_as_pennies_test()  {
        Assert.assertEquals(85, itemTest.getPriceAsIntInPennies());
    }


}
