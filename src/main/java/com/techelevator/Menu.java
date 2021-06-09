package com.techelevator;

import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	private Importer vendingMachineImporter = new Importer();
	private Inventory inventory = new Inventory(vendingMachineImporter);
	private VendingMachine vendingMachine = new VendingMachine(inventory);



	public Menu(InputStream input, OutputStream output) throws IOException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		inventory.vendingMachineStock();
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "!!! " + userInput + " is not a valid option !!!" +
					System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please Choose An Option >>> ");
		out.flush();
	}

	public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptionsPurchaseMenu(options);
			choice = getChoiceFromUserInputPurchaseMenu(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInputPurchaseMenu(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {

		}
		if (choice == null) {
			out.println(System.lineSeparator() + "!!! " + userInput + " is not a valid option !!!" +
					System.lineSeparator());

		}
		return choice;
	}

	private void displayMenuOptionsPurchaseMenu(Object[] options) {
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			System.out.println(optionNum +") " + options[i]);
		}
		System.out.println();
		System.out.println("Current Money Provided: " + displayCurrentBalance());
		System.out.print(System.lineSeparator() + "Please Choose An Option >>> ");
		out.flush();
	}


	public void displayInventory() {
		for (String each : vendingMachine.getInventoryString()) {
			System.out.println(each);
		}
	}

	public void feedMoney() throws IOException {
		System.out.print("Please Insert Dollar Bills >>> ");
		try {
			int insertedMoney = in.nextInt();
			in.nextLine();
			if (insertedMoney == 1 || insertedMoney == 2 || insertedMoney == 5 || insertedMoney == 10 ||
					insertedMoney == 20 || insertedMoney == 50 || insertedMoney == 100) {
				vendingMachine.feedMoney(insertedMoney);
				System.out.println();
				System.out.println("Thank You For Inserting $" + insertedMoney + ".00");
				System.out.println();
			} else {
				System.out.println("!!! Please Insert Valid Currency !!!");
			}
		} catch(InputMismatchException e) {
			System.out.println("!!! Please Insert Valid Currency !!!");
		}

	}

	public void selectItem() throws IOException {
		System.out.print("Please Select Product >>> ");
		String userInput = in.nextLine();
		String userSelection = vendingMachine.selectItems(userInput);
		System.out.println(userSelection);
	}

	public String displayCurrentBalance() {
		return vendingMachine.getBalanceString();
	}

	public void endTransaction() throws IOException {
		System.out.println(vendingMachine.changeInCoins());
	}


	public void returnDispenseMessage() {
		for (String each : vendingMachine.returnDispenseMessage()) {
			System.out.println(each);
		}
	}



}



