package com.techelevator;

import java.io.IOException;

import com.techelevator.Menu;

public class VendoMatic {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String [] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


	private Menu menu;

	public VendoMatic(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		boolean choiceOn = true;

		while (choiceOn) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println();
				menu.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (choiceOn) {
					System.out.println();
					String choice2 = (String) menu.getChoiceFromOptionsPurchaseMenu(PURCHASE_MENU_OPTIONS);
					if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						menu.feedMoney();
					} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						menu.selectItem();
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						menu.endTransaction();
						menu.returnDispenseMessage();
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendoMatic cli = new VendoMatic(menu);
		cli.run();
	}
}
