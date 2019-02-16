package com.bill.controller;

import java.util.*;

public class LogIn {
	public static void main(String[] args) {
		String uname, pass;
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("---------Greetings for the day---------");
			System.out.println("User Name:    ");
			uname = input.nextLine();
			System.out.println("Password:     ");
			pass = input.nextLine();
			if (uname.equals("a") && pass.equals("a")) {
				System.out.println("Login Completed Successfully");
				Home home = new Home();
				home.menu();
			} else
				System.out.println("Wrong Username Or Password");
		} catch (InputMismatchException exception) {
			System.out.println("Input type Mismatch" + exception);
		} catch (Exception exception) {
			System.out.println("Exception" + exception);
		} finally {
			input.close();
		}

	}

}
