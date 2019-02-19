package com.bill.view;

import java.util.InputMismatchException;

import com.bill.model.UserInput;

public class Menu {
	public static void homeMenu() {
		System.out.println("------Menu------\n");
		System.out.println("1.Stock\n");
		System.out.println("2.Cart\n");
		System.out.println("3.Exit\n");
	}

	public static void stockMenu() {
		System.out.println("------Menu------");
		System.out.println("1.Add Item");
		System.out.println("2.Show Item");
		System.out.println("3.Exit");
	}

	public static void cartMenu() {
		System.out.println("");
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("3. Display Cart");
		System.out.println("4. Genrate Bill");
		System.out.println("5. Exit");
	}

	public static int getUserInput() {
		try {
			return UserInput.input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Input is not a valid integer");
			UserInput.input.nextLine();
		}
		return 0;
	}

}
