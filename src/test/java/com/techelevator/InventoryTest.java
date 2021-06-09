package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventoryTest;

    @Before
    public void new_object() {
        inventoryTest = new Inventory(new Importer());
    }

    @Test
    public void inventory_at_startup_test(){
        Assert.assertEquals(5, inventoryTest.returnCurrentInventory("C4"));
    }

    @Test
    public void subtract_one_from_inventory_test() {
        inventoryTest.subtractFromInventory("C4");
        Assert.assertEquals(4, inventoryTest.returnCurrentInventory("C4"));
    }

    @Test
    public void subtract_three_from_inventory_test() {
        inventoryTest.subtractFromInventory("A1");
        inventoryTest.subtractFromInventory("A1");
        inventoryTest.subtractFromInventory("A1");
        Assert.assertEquals(2, inventoryTest.returnCurrentInventory("A1"));
    }

}
