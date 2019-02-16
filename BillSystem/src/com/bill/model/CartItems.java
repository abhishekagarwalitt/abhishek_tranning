package com.bill.model;

public class CartItems {
	private int itemId;
	private String itemName;
	private double itemPrice = 1.0;
	private int itemQty;

	public void setItem(int itemId, String itemName, double itemPrice, int itemQty) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQty = itemQty;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public double getItemTotalPrice() {
		return itemPrice * itemQty;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setIId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItempPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	@Override
	public String toString() {
		String state = itemId + " " + itemName + " -  Rs" + itemPrice + " x " + itemQty;
		return state;
	}
}