package com.bill.controller;

import java.util.ArrayList;
import com.bill.model.StockItem;
import com.bill.view.Menu;

public class Home {
	private ArrayList<StockItem> list = new ArrayList<StockItem>();

	void menu() {
		int option = 0;
		do {
			Menu.homeMenu();
			option = Menu.getUserInput();
			if (option != 0) {
				switch (option) {
				case 1:
					Stock stock = new Stock(list);
					stock.menu();
					break;
				case 2:
					Cart cart = new Cart(list);
					cart.menu();
					break;
				case 3:
					return;
				default:
					System.out.println("Invaild Input Enter again");
				}
			} else {
				System.out.println("Invaild Input Enter again");
			}
		} while (option != 3);
	}

}
