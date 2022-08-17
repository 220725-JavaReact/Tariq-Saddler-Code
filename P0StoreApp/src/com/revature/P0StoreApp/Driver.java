package com.revature.P0StoreApp;

import java.util.Scanner;

import com.revature.P0StoreApp.util.Menu;

public class Driver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("open or test?");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("open"))
		{
			Menu.open();
		}
		if(userInput.equals("test"))
		{
			Menu.test();
		}
	}

}
