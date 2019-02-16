package com.bill.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.bill.model.CartItems;
import com.bill.model.StockItem;

public class Cart {
	ArrayList<StockItem> list = new ArrayList<StockItem>();
	ArrayList<CartItems> cartList = new ArrayList<CartItems>();

	Cart(ArrayList<StockItem> list) {
		this.list = list;
	}

	public void startScreen() {
		System.out.println("");
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("3. Display Cart");
		System.out.println("4. Genrate Bill");
		System.out.println("5. Exit");
	}

	public void menu() {
		int option;
		do {
			startScreen();
			option = getUserInput();
			if (option != 0) {
				switch (option) {
				case 1:
					displayStoreProducts();
					addProductToCart();
					break;
				case 2:
					removeCartProductByPID();
					break;
				case 3:
					printCartItems();
					break;
				case 4:
					Bill bill = new Bill(cartList);
					bill.genrateBill();
					break;
				case 5:
					break;
				default:
					System.out.println("Invaild Input Enter again");
				}
			}
		} while (option != 5);
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

	private void addProductToCart() {
		System.out.println("Enter Item Id");
		int id = getUserInput();
		System.out.println("Enter Quantity");
		int quantity = getUserInput();
		addProductToCartByPID(id, quantity);
	}

	public void addProductToCartByPID(int id, int quantity) {
		CartItems cartItems = new CartItems();
		StockItem StockItem = null;
		int flag = 0;
		for (StockItem StockItem2 : list) {
			if (StockItem2.getItemId() == id) {
				StockItem = StockItem2;
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println("Invaild Id\n");
		if (StockItem != null) {
			if (StockItem.getItemQty() >= quantity) {
				cartItems.setItem(StockItem.getItemId(), StockItem.getItemName(), StockItem.getItemPrice(), quantity);
				cartList.add(cartItems);
				updateStock(id, quantity);
			} else {
				System.out.println("Insufficient Quantity");
			}
		}
	}

	void updateStock(int id, int quantity) {
		int count = 0;
		for (StockItem StockItem : list) {
			if (StockItem.getItemId() == id) {
				int temp = StockItem.getItemQty();
				temp = temp - quantity;
				list.get(count).setItemQty(temp);
				break;
			}
			count = +1;
			;
		}

	}

	CartItems getCartProductByProductID(int id) {
		CartItems cartItems1 = null;
		for (CartItems cartItems2 : cartList) {
			if (cartItems2.getItemId() == id) {
				cartItems1 = cartItems2;
				break;
			}
		}
		return cartItems1;
	}

	public void removeCartProductByPID() {
		System.out.println("Enter Item Id");
		int id = getUserInput();
		int flag = 0; 
		CartItems cartItems1 = getCartProductByProductID(id);

		for (CartItems cartItems : cartList) {
			if (cartItems.equals(cartItems1)) {

				cartList.remove(cartItems);
				System.out.println("Removed\n");
				flag = 1;
				break;

			}

		}
		if (flag == 0)
			System.out.println("Product is not in the Cart\n");

	}

	void printCartItems() {
		System.out.println("Your Cart:");
		if (cartList.isEmpty()) {
			System.out.println("Cart is empty");
		} else
			for (CartItems cartItems : cartList) {
				System.out.println(cartItems.toString());
			}
	}

	private void displayStoreProducts() {
		System.out.println(list.size() + " items. ");
		for (StockItem item : list) {
			System.out.println(item.toString());
		}
	}

}
