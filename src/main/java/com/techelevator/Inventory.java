package com.techelevator;

import java.util.Map;
import java.util.TreeMap;

public class Inventory  {

    private Importer importerObject;
    private TreeMap<String, Integer> inventoryList = new TreeMap<String, Integer>();

    public Inventory(Importer importerObject) {
        this.importerObject = importerObject;
        stockVendingMachineAtStartup();
    }

    private void stockVendingMachineAtStartup() {
        for (String[] item : importerObject.inventoryArrayList()) {
            int initialStock = 5;
            inventoryList.put(item[0], initialStock);
        }
    }

    public Map<String, Item> vendingMachineStock() {
        return importerObject.mapOfSlotAndItem();
    }

    public void subtractFromInventory(String slotLocation) {
        inventoryList.put(slotLocation, inventoryList.get(slotLocation) - 1);
    }

    public int returnCurrentInventory(String slotLocation) {
        return inventoryList.get(slotLocation);
    }


}
