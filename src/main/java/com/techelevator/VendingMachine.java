package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    private Inventory vendingMachineInventory;
    private Money vendingMachineMoney;
    private Importer vendingMachineFileImporter;
    private Log vendingMachineLog;
    private Transaction vendingMachineTransaction;


    public VendingMachine(Inventory vendingMachineInventory) throws IOException {
        this.vendingMachineInventory = vendingMachineInventory;
        this.vendingMachineFileImporter = new Importer();
        this.vendingMachineInventory = new Inventory(vendingMachineFileImporter);
        this.vendingMachineMoney = new Money();
        this.vendingMachineLog = new Log();
        this.vendingMachineTransaction = new Transaction();
    }

    public void feedMoney(int billInserted) throws IOException {
        vendingMachineMoney.addMoney(billInserted);
        String billConvertToString = "$" + billInserted + ".00";
        vendingMachineLog.logEvent("FEED MONEY:", billConvertToString, vendingMachineMoney.getBalanceAsString());
    }

    public void subtractMoney (String slotLocation) {
        int debit = vendingMachineInventory.vendingMachineStock().get(slotLocation).getPriceAsIntInPennies();
        vendingMachineMoney.withdrawMoney(debit);
    }

    public int getBalanceInPennies() {
        int balance = vendingMachineMoney.getBalanceInPennies();
        return balance;
    }

    public String getBalanceString() {
        String returnString = vendingMachineMoney.getBalanceAsString();
        return returnString;
    }

    public String changeInCoins() throws IOException {
        vendingMachineLog.logEvent("GIVE CHANGE:", getBalanceString(), "$0.00");
        String returnString = vendingMachineMoney.returnChangeInCoins(getBalanceInPennies());
        return returnString;
    }

    public void subtractFromInventory(String slotLocation) {
        vendingMachineInventory.subtractFromInventory(slotLocation);
    }

    public List<String> getInventoryString() {
        TreeMap<String, Item> returnMap = vendingMachineFileImporter.mapOfSlotAndItem();

        List<String> inventory = new ArrayList<>();

        for (Map.Entry<String, Item> entry : returnMap.entrySet()) {
            String inventoryValueToString = String.valueOf(vendingMachineInventory.returnCurrentInventory
                    (entry.getKey()));

            if (inventoryValueToString.contentEquals("0")) {
                inventoryValueToString = "Sold Out";
            }

            String formattedString = String.format("%-5s %-22s %-5s %-5s", entry.getKey(), entry.getValue().getName(),
                    entry.getValue().getPrice(), inventoryValueToString);
            inventory.add(formattedString);
        }
        return inventory;
    }

    public List<String> returnDispenseMessage() {
        return vendingMachineTransaction.returnListOfMessages();
    }

    public String selectItems(String slotLocation) throws IOException {
        try {

            if (vendingMachineInventory.returnCurrentInventory(slotLocation) == 0) {
                return "\n !!! " + vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() +
                        " is SOLD OUT !!! \n";
            } else if (vendingMachineMoney.getBalanceInPennies() < vendingMachineInventory.vendingMachineStock().
                    get(slotLocation).getPriceAsIntInPennies()) {
                return "\n!!! Please Insert Additional Funds !!!\n";
            } else {
                String balanceBeforePurchase = getBalanceString();
                subtractFromInventory(slotLocation);
                subtractMoney(slotLocation);
                System.out.println();
                String successfulPurchase = "*** Dispensed: " + vendingMachineInventory.vendingMachineStock().
                        get(slotLocation).getName() + " *** \n";
                vendingMachineTransaction.addDispenseMessageToList(vendingMachineInventory.vendingMachineStock().
                        get(slotLocation).getItemDispenseMessage());
                // add transaction event to log.txt
                vendingMachineLog.logEvent(vendingMachineInventory.vendingMachineStock().get(slotLocation).
                        getName() + " " + slotLocation, balanceBeforePurchase, getBalanceString());
                return successfulPurchase;

            }

        } catch (NullPointerException e) {
            return "!!! Please Enter A Valid Selection !!! \n";
        }



    }


}
