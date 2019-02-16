package com.bill.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bill.model.StockItem;

public class Stock {

	Scanner input = new Scanner(System.in);
	ArrayList<StockItem> list = new ArrayList<StockItem>();

	Stock(ArrayList<StockItem> list) {
		this.list = list;
	}

	public void addItem() {

		input.nextLine();
		System.out.println();
		System.out.println("enter in the ID of your item");
		int itemId = Integer.parseInt(input.nextLine());

		System.out.println("enter in the name of your item");
		String itemName = input.nextLine();

		System.out.println("enter in the price of your item");
		double itemPrice = input.nextDouble();

		System.out.println("enter in the Qty of your item");
		int itemQty = input.nextInt();

		StockItem item = new StockItem(itemId, itemName, itemPrice, itemQty);
		list.add(item);
		System.out.println("Item Added");

	}

	public void displayItem() {
		System.out.println(list.size() + " items. ");
		for (StockItem item : list) {
			System.out.println(item.toString());
		}
	}

	public void menu() {
		int option = 0;
		do {
			startScreen();
			option = getUserInput();
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
			}
		} while (option != 3);
	}

	private int getUserInput() {

		try {
			return input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Input is not a valid integer");
			input.nextLine();
		}
		return 0;
	}

	public void startScreen() {
		System.out.println("------Menu------");
		System.out.println("1.Add Item");
		System.out.println("2.Show Item");
		System.out.println("3.Exit");
	}

}
