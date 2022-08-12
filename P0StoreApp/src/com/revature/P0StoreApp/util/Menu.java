package com.revature.P0StoreApp.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.P0StoreApp.dl.CustomerDAO;
import com.revature.P0StoreApp.dl.DAO;
import com.revature.P0StoreApp.dl.StoreDAO;
import com.revature.P0StoreApp.models.cart;
import com.revature.P0StoreApp.models.customer;
import com.revature.P0StoreApp.models.products;
import com.revature.P0StoreApp.models.store;

public class Menu {
	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	public static void open()
	{
		loginOrRegisterHere();
		
		
		
		
		
		
//		Scanner scanner = new Scanner(System.in);
//		
//		store RaisinKings = new store();
//		
//		cart myCart = new cart();
//		
//		products RaisinBran = new products();
//		products RaisinBox = new products();
//		
//		RaisinBran.setName("Raisin Bran");
//		RaisinBran.setPrice(12.00);
//		RaisinBran.setInventory(10);
//		
//		RaisinBox.setName("Box of Raisins");
//		RaisinBox.setPrice(15.00);
//		RaisinBox.setInventory(10);
//		
//		ArrayList<products> productList = new ArrayList<products>();
//		
//		//ArrayList<products> productList = new ArrayList<products>();
//		productList.add(RaisinBran);
//		
//		RaisinKings.setStoreProducts(productList);
//		
//		String userInput = "";
//		//String productInput = "";
//		do {
//			System.out.println("Welcome to Raisin Kings, you highness.");
//			System.out.println("Where you may purchase raisin-based products for very reasonable prices!");
//			System.out.println("[1] Browse Products");
//			System.out.println("[2] Checkout");
//			System.out.println("[3] View Cart");
//			System.out.println("[4] View Orders");
//			System.out.println("[x] Exit");
//			
//			userInput = scanner.nextLine();
//			switch(userInput)
//			{
//			case "1":
//				//create team
//				do {
//				String productInput = "";
//				System.out.println(RaisinKings.getStoreProducts());
//				System.out.println("Which item would you like to add to your cart?");
//				System.out.println("[x] to exit");
//				productInput = scanner.nextLine();
//				
//				for(int i = 0; i < RaisinKings.size(); i++)
//				{
//					if(RaisinKings.getStoreProducts().get(i).getName() == productInput)//Name of product in store matches input
//					{
//						myCart.setProductInCart(RaisinKings.getStoreProducts().get(i).getName());//It really should be an arraylist
//						myCart.setAmountInCart(myCart.getAmountInCart() + 1);
//						myCart.setPriceOfProduct(RaisinKings.getStoreProducts().get(i).getPrice());
//						
//					}
//				}
//				}while(!userInput.equals("x"));
//				break;
//			case "2":
//				//get all teams
//				// print out all the teams
//				break;
//			case "3":
//				//print out teams and their points
//				break;
//			case "4":
//				break;
//			case "x":
//				System.out.println("Adieu.");
//				break;
//			default:
//				System.out.println("Invalid input");
//				break;
//			}
//		}while (!userInput.equals("x")); // ! means not, .equals returns a boolean, negates boolean
	}
	
	public static void loginOrRegisterHere()
    {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
        System.out.println("Login or Register? (Or quit)");
        userInput = scanner.nextLine();
        if(userInput.equals("login"))
        {
            login();
        }
        else if(userInput.equals("register"))
        {
            register();
        }
        else if(userInput.equals("accounts"))
        {
        	showEmAll();
        }
        else if(userInput.equals("quit"))
        {
            System.out.println("Adieu, your exellency.");
        }
        else
        {
        	System.out.println("INVALID INPUT");
        	loginOrRegisterHere();
        }
            
            
    }
	
	public static void login()
	{
		String currentUN = "";
		String currentPW = "";
		int currentID = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Username: ");
		currentUN = scanner.nextLine();
		System.out.println("Enter your Password: ");
		currentPW = scanner.nextLine();
		
		for(customer person: customerDao.getAllInstances()) 
		{
			if(person.getC_un().equals(currentUN) && person.getC_pw().equals(currentPW))
			{
				System.out.println("At your service, " + person.getFname() + " " + person.getLname() + ".");
				currentID = person.getCustomerID();
				shopHere(currentID, person.getFname());
				break;
			}
		}
		
		
		loginOrRegisterHere();
	}
	
	public static void register()
	{
		Scanner scanner = new Scanner(System.in);
		String fname = "";
		String lname = "";
		String un = "";
		String pw = "";
		String email = "";
		System.out.println("Enter First Name: ");
		fname = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		lname = scanner.nextLine();
		System.out.println("Enter new Username: ");
		un = scanner.nextLine();
		System.out.println("Enter new password: ");
		pw = scanner.nextLine();
		System.out.println("Enter Email Address: ");
		email = scanner.nextLine();
		
		customer newCustomer = new customer(fname, lname, un, pw, email);
		customerDao.addInstance(newCustomer);
		
		
		loginOrRegisterHere();
	}
	
	public static void showEmAll()
	{
		
		for(customer person: customerDao.getAllInstances()) {
			System.out.println("NAME: " + person.getFname() + " " + person.getLname() + ", UN: " + person.getC_un() + ", Email: " + person.getEmail());
		}
		loginOrRegisterHere();
	}
	
	public static void shopHere(int currentID, String currentName)
	{
		int i = 1;
		System.out.println("Master " + currentName + ", please select the store ");
		for(store shop: storeDao.getAllInstances()) {
			System.out.println("Store " + i + ": " + shop.getStoreName() + " at " + shop.getStoreAddress() + ".");
			i++;
		}
	}
}