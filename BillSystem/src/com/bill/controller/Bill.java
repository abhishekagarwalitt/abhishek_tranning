package com.bill.controller;

import java.util.ArrayList;

import com.bill.model.CartItems;

public class Bill {
	ArrayList<CartItems> cartList = new ArrayList<CartItems>();

	Bill(ArrayList<CartItems> cart_list) {
		this.cartList = cart_list;
	}

	void genrateBill() {
		if (cartList.isEmpty()) {
			System.out.println("Cart is empty");
		} else
			for (CartItems cart_list1 : cartList) {
				System.out.println(cart_list1.toString() + " Total ammount= " + cart_list1.getItemTotalPrice());
			}
	}

}
