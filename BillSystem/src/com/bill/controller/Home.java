package com.bill.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.bill.model.StockItem;

public class Home {
	ArrayList<StockItem> list = new ArrayList<StockItem>();

	public void startScreen() {
		System.out.println("------Menu------\n");
		System.out.println("1.Stock\n");
		System.out.println("2.Cart\n");
		System.out.println("3.Exit\n");
	}

	public void menu() {
		int option;
		do {
			startScreen();
			option = getUserInput();
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
					System.exit(0);
				default:
					System.out.println("Invaild Input Enter again");
				}
			}
		} while (option != 3);
	}

	private int getUserInput() {
		Scanner input = new Scanner(System.in);
		try {
			return Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
		} 
		return 0;
	}

}
