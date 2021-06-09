package com.techelevator;
import java.util.List;
import java.util.ArrayList;

public class Transaction {
    private List<String> itemsSelected = new ArrayList<>();

    public void addDispenseMessageToList(String itemMessage) {
        // will add item dispense message to the list of items the user has selected
        itemsSelected.add(itemMessage);

    }
    public List<String> returnListOfMessages () {
        List<String> returnList = itemsSelected;
        itemsSelected = new ArrayList<>();
        return returnList;
    }
}
