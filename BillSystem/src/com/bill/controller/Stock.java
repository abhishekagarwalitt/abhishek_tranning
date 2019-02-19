package com.bill.controller;

import java.util.ArrayList;
import com.bill.model.StockItem;
import com.bill.model.UserInput;
import com.bill.view.Menu;

public class Stock {

	private ArrayList<StockItem> list = new ArrayList<StockItem>();

	Stock(ArrayList<StockItem> list) {
		this.list = list;
	}

	void menu() {
		int option = 0;
		do {
			Menu.stockMenu();
			option = Menu.getUserInput();
			if (option != 0) {
				switch (option) {
				case 1:
					addItem();
					break;
				case 2:
					displayItem();
					break;
				case 3:
					break;
				default:
					System.out.println("Invaild Input Enter again");
				}
			} else {
				System.out.println("Invaild Input Enter again");
			}
		} while (option != 3);
	}

	void addItem() {

		UserInput.input.nextLine();
		System.out.println();
		System.out.println("enter in the ID of your item");
		int itemId = Integer.parseInt(UserInput.input.nextLine());

		System.out.println("enter in the name of your item");
		String itemName = UserInput.input.nextLine();

		System.out.println("enter in the price of your item");
		double itemPrice = UserInput.input.nextDouble();

		System.out.println("enter in the Qty of your item");
		int itemQty = UserInput.input.nextInt();

		StockItem item = new StockItem(itemId, itemName, itemPrice, itemQty);
		list.add(item);
		System.out.println("Item Added");

	}

	void displayItem() {
		System.out.println(list.size() + " items. ");
		for (StockItem item : list) {
			System.out.println(item.toString());
		}
	}

}
