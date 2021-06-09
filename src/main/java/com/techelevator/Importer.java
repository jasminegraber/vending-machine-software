package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Importer {

    private String fileName = "vendingmachine.csv";
    private File inventoryFile = new File(fileName);

    private List<String> getListOfAllLines() {   // will access vending machine file and place each line into a list
        List<String> listOfInputFileLines = new ArrayList<String>();

        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                listOfInputFileLines.add(fileScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return listOfInputFileLines;
    }


    public List<String[]> inventoryArrayList() { // breaks up each entry into a list

        List<String[]> inventoryArray = new ArrayList<String[]>();

        for (String currentString : getListOfAllLines()) {
            inventoryArray.add(currentString.split("\\|"));
        }
        return inventoryArray;

    }

    public TreeMap<String, Item> mapOfSlotAndItem() {
        // adds the list of items to a map depending on the type of product
        TreeMap<String, Item> inventoryMap = new TreeMap<String, Item>();
        for (String currentString : getListOfAllLines()) {
            String[] splitList = currentString.split("\\|");

            if(splitList[3].equals("Chip")) {
                Chip chip = new Chip(splitList[1], splitList[2]);
                inventoryMap.put(splitList[0], chip);
            } else if (splitList[3].equals("Candy")) {
                Candy candy = new Candy(splitList[1], splitList[2]);
                inventoryMap.put(splitList[0], candy);
            } else if (splitList[3].equals("Drink")) {
                Drink drink = new Drink(splitList[1], splitList[2]);
                inventoryMap.put(splitList[0], drink);
            } else if (splitList[3].equals("Gum")) {
                Gum gum = new Gum(splitList[1], splitList[2]);
                inventoryMap.put(splitList[0], gum);
            }

        }

        return inventoryMap;

    }






}
