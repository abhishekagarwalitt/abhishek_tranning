package com.bill.controller;

import java.util.ArrayList;
import com.bill.model.CartItems;
import com.bill.model.StockItem;
import com.bill.view.Menu;

public class Cart {
	private ArrayList<StockItem> list = new ArrayList<StockItem>();
	private ArrayList<CartItems> cartList = new ArrayList<CartItems>();

	Cart(ArrayList<StockItem> list) {
		this.list = list;
	}

	public void menu() {
		int option;
		do {
			Menu.cartMenu();
			option = Menu.getUserInput();
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
			} else {
				System.out.println("Invaild Input Enter again");
			}
		} while (option != 5);
	}

	private void addProductToCart() {
		int id = 0, quantity = 0;
		System.out.println("Enter Item Id");
		id = Menu.getUserInput();
		if (id != 0) {
			System.out.println("Enter Quantity");
			quantity = Menu.getUserInput();
			if (quantity != 0) {
				addProductToCartByPID(id, quantity);
			} else {
				System.out.println("Quantity should be greater then 0");
				return;
			}
		} else {
			System.out.println("id should be greater then 0");
			return;
		}
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
				decreaseStock(id, quantity);
			} else {
				System.out.println("Insufficient Quantity");
			}
		}
	}

	void decreaseStock(int id, int quantity) {
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

	void increaseStock(int id, int quantity) {
		int count = 0;
		for (StockItem StockItem : list) {
			if (StockItem.getItemId() == id) {
				int temp = StockItem.getItemQty();
				temp = temp + quantity;
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

		int flag = 0;
		int id = Menu.getUserInput();
		if (id != 0) {
			CartItems cartItems1 = getCartProductByProductID(id);

			for (CartItems cartItems : cartList) {
				if (cartItems.equals(cartItems1)) {

					cartList.remove(cartItems);
					System.out.println("Removed\n");
					increaseStock(id, cartItems.getItemQty());
					flag = 1;
					break;

				}

			}
			if (flag == 0)
				System.out.println("Product is not in the Cart\n");
		} else {
			return;
		}

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
