package com.bill.controller;

import java.util.*;
import com.bill.model.UserInput;

public class LogIn {
	public static void main(String[] args) {
		String uname, pass;
		UserInput userInput = new UserInput();
		int flag = 0;
		System.out.println("---------Greetings for the day---------");
		try {
			do {
				userInput.openStream();
				System.out.println("User Name:    ");
				uname = UserInput.input.nextLine();
				System.out.println("Password:     ");
				pass = UserInput.input.nextLine();
				if (uname.equals("a") && pass.equals("a")) {
					System.out.println("Login Completed Successfully");
					Home home = new Home();
					home.menu();
					flag = 1;
				} else {
					System.out.println("Wrong Username Or Password");
				}
			} while (flag == 0);

		} catch (InputMismatchException exception) {
			System.out.println("Input type Mismatch" + exception);
		} catch (Exception exception) {
			System.out.println("Exception" + exception);
		} finally {
			userInput.closeStream();
		}
	}
}
