package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class VendingMachineTest {

    private Inventory vendingMachineInventory;
    private Money vendingMachineMoney;
    private Importer vendingMachineImporter;
    private VendingMachine vendingMachineTest;

    @Before
    public void new_object() throws IOException {
        vendingMachineImporter = new Importer();
        vendingMachineInventory = new Inventory(vendingMachineImporter);
        vendingMachineTest = new VendingMachine(vendingMachineInventory);
        vendingMachineMoney = new Money();
    }

    @Test
    public void name_test(){
        Assert.assertEquals("Cloud Popcorn", vendingMachineInventory.vendingMachineStock().get("A4")
                .getName());
    }

    @Test
    public void price_test() {
        Assert.assertEquals("3.65",vendingMachineInventory.vendingMachineStock().get("A4").getPrice());
    }

    @Test
    public void balance_in_pennies_test() {
        vendingMachineMoney.addMoney(10);
        Assert.assertEquals(1000, vendingMachineMoney.getBalanceInPennies());
    }

    @Test
    public void successful_purchase_test() throws IOException {
        vendingMachineTest.feedMoney(2);
        vendingMachineInventory.vendingMachineStock().get("A2").getPriceAsIntInPennies();
        Assert.assertEquals("*** Dispensed: Stackers *** \n", vendingMachineTest.selectItems("A2"));
    }

}
