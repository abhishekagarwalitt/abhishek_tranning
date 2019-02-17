package com.bill.model;

import java.util.Scanner;

public class UserInput {

	public static Scanner input = null;

	public void openStream() {
		input = new Scanner(System.in);
	}

	public void closeStream() {
		input.close();
	}

}
