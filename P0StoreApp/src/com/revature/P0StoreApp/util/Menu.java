package com.revature.P0StoreApp.util;

import java.util.regex.*;    
import java.util.*; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.revature.P0StoreApp.dl.CustomerDAO;
import com.revature.P0StoreApp.dl.DAO;
import com.revature.P0StoreApp.dl.OHProductListDAO;
import com.revature.P0StoreApp.dl.OrdersDAO;
import com.revature.P0StoreApp.dl.StoreDAO;
import com.revature.P0StoreApp.dl.ProductsDAO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.revature.P0StoreApp.models.customer;
import com.revature.P0StoreApp.models.oh_product_list;
import com.revature.P0StoreApp.models.order_history;
import com.revature.P0StoreApp.models.products;
import com.revature.P0StoreApp.models.store;
import com.revature.P0StoreApp.test.P0StoreAppTest;
import com.revature.P0StoreApp.test.Test;
import com.revature.P0StoreApp.util.Logger.LogLevel;

import java.lang.reflect.Method;


public class Menu {
	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	private static DAO<products> productDao = new ProductsDAO();
	private static DAO<order_history> ordersDao = new OrdersDAO();
	private static DAO<oh_product_list> ohproductsDao = new OHProductListDAO();
	public static Logger logger = Logger.getLogger();
	public static void open()
	{
		logger.log(LogLevel.info, "Starting the program...");
		loginOrRegisterHere();
		
	}
	
	public static void test()
	{
		System.out.println("Unit testing starting...");
		
		System.out.println("--------------------------");
		order_history newOrder = new order_history(0, 1, 1, "datetime", 10.99);
		ordersDao.addInstance(newOrder);
		
		P0StoreAppTest StoreTest = new P0StoreAppTest();

		//Reflection selecting every method and running it
		Class StoreTestClass = P0StoreAppTest.class;
		
		//Counter
		int totalUnitTests = 0; //Will count how many unit tests we are running
		int ignoredUnitTests = 0;
		int passedUnitTests = 0;
		int failedUnitTests = 0;

		Method[] StoreTestMethods = StoreTestClass.getDeclaredMethods();

		//Foreach loop
		for (Method method : StoreTestMethods) {
			
			if (method.isAnnotationPresent(Test.class)) {
				totalUnitTests++;
				Test test = method.getAnnotation(Test.class);

				//It will only run this method invoke if the metadata "enabled" in our Test annotation is set to true
				if (test.enable()) {
					System.out.println(method.getName());
					try {
						//Grabs the return result of that method
						try {
							method.invoke(StoreTest);
							passedUnitTests++;

							System.out.println("Passed");
						} catch (InvocationTargetException e) {
							//TODO: handle exception
							System.out.println(e.getTargetException().getMessage());
							failedUnitTests++;
						}
					} 
					catch(Exception e)
					{
						e.printStackTrace();
					}
			
				}
				else
				{
					ignoredUnitTests++;
				}
			}

			
		}
		System.out.println("Total Unit Tests: " + totalUnitTests);
		System.out.println("PASSED:  " + passedUnitTests);
		System.out.println("FAILED:  " + failedUnitTests);
		System.out.println("IGNORED: " + ignoredUnitTests);
	}
	
	public static void loginOrRegisterHere()
    {
		logger.log(LogLevel.info, "loginOrRegisterHere() method executing");
		
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
        	logger.log(LogLevel.info, "Exiting program. Goodbye!");
            System.out.println("Adieu, your exellency.");
        }
        else
        {
        	logger.log(LogLevel.warning, "INVALID INPUT for ");
        	System.out.println("INVALID INPUT");
        	loginOrRegisterHere();
        }
            
            
    }
	
	public static void login()
	{
		logger.log(LogLevel.info, "Input login credentials...");
		
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
				currentID = customerDao.findID(person);
				storeSelect(currentID, person.getFname());
				break;
			}
		}
		
		logger.log(LogLevel.warning, "INVALID CREDENTIALS. Consider registering.");
		System.out.println("INVALID CREDENTIALS. Consider registering.");
		loginOrRegisterHere();
	}
	
	public static void register()
	{
		logger.log(LogLevel.info, "Input new registration form.");
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		 
		Scanner scanner = new Scanner(System.in);
		String fname = "";
		String lname = "";
		String un = "";
		String pw = "";
		String email = "";
		while(fname.length() < 1)
		{
			System.out.println("Enter First Name: ");
			fname = scanner.nextLine();
			if(fname.length()<1)
			{
				logger.log(LogLevel.warning, "NULL INPUT. Please input your first name.");
				System.out.println("try again");
			}
		}
		while(lname.length() < 1)
		{
			System.out.println("Enter Last Name: ");
			lname = scanner.nextLine();
			if(lname.length() < 1)
			{
				logger.log(LogLevel.warning, "NULL INPUT. Please input your last name.");
				System.out.println("try again");
			}
		}
		while(un.length() < 5)
		{
			
			System.out.println("Enter new Username: ");
			un = scanner.nextLine();
			if(un.length() >4)
			{
				for(customer person: customerDao.getAllInstances())
				{
					if(person.getC_un().equals(un))
					{
						logger.log(LogLevel.warning, "USERNAME TAKEN. Try to make username more unique.");
						System.out.println("THAT USERNAME IS TAKEN.");
						un = "no";
						break;
					}
				}
			}
			else
			{
				logger.log(LogLevel.warning, "USERNAME TOO SHORT");
				System.out.println("USERNAME TOO SHORT");
			}
		}
		while(pw.length() < 5)
		{
			System.out.println("Enter new password: ");
			pw = scanner.nextLine();
			if(pw.length()<5)
			{
				logger.log(LogLevel.warning, "PASSWORD TOO SHORT");
				System.out.println("PASSWORD TOO SHORT");
			}
		}
		boolean moveOn = false;
		while(!moveOn)
		{
			moveOn = true;
			System.out.println("Enter Email Address: ");
			email = scanner.nextLine();
			Matcher matcher = pattern.matcher(email);
			if(!matcher.matches())
			{
				logger.log(LogLevel.warning, "INVALID EMAIL FORMAT. Proper format: example@domain.com");
				System.out.println("INVALID EMAIL FORMAT.");
				moveOn = false;
			}
			if(moveOn)
			{
				for(customer person: customerDao.getAllInstances())
				{
					
					if(person.getEmail().equals(email))
					{
						logger.log(LogLevel.warning, "THAT EMAIL HAS AN ACCOUNT. Try logging in.");
						System.out.println("THAT EMAIL IS TAKEN.");
						moveOn = false;
						break;
						//register();
					}
				}
			}
		}
		logger.log(LogLevel.info, "New customer registered!");
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
	
	public static void storeSelect(int currentID, String currentName)
	{
		logger.log(LogLevel.info, "Select store method executing...");
		
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		int i = 1;
		System.out.println("Master " + currentName + ", please select the store's number you would like to shop at ");
		for(store shop: storeDao.getAllInstances())
		{
			System.out.println("Store " + i + ": " + shop.getStoreName() + " at " + shop.getStoreAddress() + ".");
			i++;
		}
		userInput = scanner.nextInt();
		for(store shop: storeDao.getAllInstances()) 
		{
			//System.out.println(shop.getStoreID()+ " == " + (userInput - 1));
			if(shop.getStoreID() == userInput -1)
			{
				shopHere(currentID, currentName, shop.getStoreID()+1, shop.getStoreName());
				break;
			}
		}
		
		logger.log(LogLevel.warning, "INVALID STORE NUMBER.");
		System.out.println("NUMBER NOT VALID");
		storeSelect(currentID, currentName);
	}
	
	public static void shopHere(int currentID, String currentName, int storeID, String storeName)
	{
		logger.log(LogLevel.info, "Store successfully entered.");
		logger.log(LogLevel.info, "Welcome!");
		
		Scanner scanner = new Scanner(System.in);
		int i =  0;
		String userInput = "";
		int currentProductID = -1;
		String currentProduct = "";
		int currentInv = 0;
		double cartTotal = 0.0;
		double currentPrice = 0.0;
		int numOfItems = 0;
		
		ArrayList<Integer> cart = new ArrayList<Integer>();//lol the cart is just a list of product ID's
		System.out.println("------------------------------");
		System.out.println("Welcome to " + storeName + "!");
		System.out.println("------------------------------");
		
		String productNameInput = "";
		
		do {
			logger.log(LogLevel.info, "Displaying options.");
			
			System.out.println("-----------------------------------------------");
			System.out.println("Please type what you would like to do.");
			System.out.println("'Shop': Shop at this store.");
			System.out.println("'Cart': View contents of your cart");
			System.out.println("'History': View your order history.");
			System.out.println("'Checkout': Check out your current cart.");
			System.out.println("'Stores': Leave this store (and cart). 'Quit': Log out.");
			System.out.println("'Replenish': Replenish inventory");
			System.out.println("-----------------------------------------------");
			userInput = scanner.nextLine();
			
			if(userInput.equals("Shop"))
			{
				
				logger.log(LogLevel.info, "'Shop' entered. Displaying products from this store.");
				for(products product: productDao.getAllInstances())
				{
					if(storeID == product.getMyStoreID())
					{
						System.out.println(product.getName()+ ": " + product.getDetails() + "-----$" + product.getPrice() + "-----(" + product.getInventory() + ") IN STOCK");
						i++;
					}
				}
				
				logger.log(LogLevel.info, "Prompting user to input the product's name.");
				System.out.println("------------------------------");
				System.out.println("Which product would you like to add to your cart? (Type the name of the product)");
				productNameInput = scanner.nextLine();
				i = 0;
				for(products product: productDao.getAllInstances())
				{
		//			System.out.println(product.getProductID());
		//			System.out.println(product.getName());
					if(productNameInput.equals(product.getName()))
					{
						currentProductID = productDao.findID(product);
						//System.out.println("PID: " + currentProductID);
						currentProduct = product.getName();
						currentPrice = product.getPrice();
						currentInv = product.getInventory();
						break;
					}
					i++;
				}
				if(!currentProduct.equals(""))
				{
					System.out.println("------------------------------");
					System.out.println("How many units of " + currentProduct + " would you like to purchase? (" + currentInv + ") IN STOCK");
					numOfItems = scanner.nextInt();
					scanner.nextLine();
					if(numOfItems > currentInv)
					{
						logger.log(LogLevel.warning, "OVERDRAFT. Yoy can't take more than what is available.");
						System.out.println("OVERDRAFT. You can't take more than what is available.");
					}
					else
					{
						logger.log(LogLevel.info, "Adding item to cart and decrementing store inventory");
						productDao.decrementInventory(numOfItems, currentProductID);
						
						for(int x = 0; x<numOfItems; x++)
						{
							cart.add(currentProductID);
						}
						
						cartTotal += numOfItems * currentPrice;
					}
				}
				else
				{
					logger.log(LogLevel.warning, "INVALID PRODUCT NAME");
					System.out.println("INVALID INPUT. Please read/type product names carefully.");
				}
				
				
				System.out.println("------------------------------");
				
			}
			
			
			else if(userInput.equals("replenish"))
			{
				logger.log(LogLevel.info, "'Replenish' entered. Displaying products from this store.");
				for(products product: productDao.getAllInstances())
				{
					if(storeID == product.getMyStoreID())
					{
						System.out.println(product.getName()+ ": " + product.getDetails() + "-----$" + product.getPrice() + "-----(" + product.getInventory() + ") IN STOCK");
						i++;
					}
				}
				System.out.println("------------------------------");
				System.out.println("Which product would you like to add to replenish? (Type the name of the product)");
				productNameInput = scanner.nextLine();
				i = 0;
				for(products product: productDao.getAllInstances())
				{
		//			System.out.println(product.getProductID());
		//			System.out.println(product.getName());
					if(productNameInput.equals(product.getName()))
					{
						currentProductID = productDao.findID(product);
						System.out.println("PID: " + currentProductID);
						currentProduct = product.getName();
						currentPrice = product.getPrice();
						currentInv = product.getInventory();
						break;
					}
					i++;
				}
				if(!currentProduct.equals(""))
				{
					logger.log(LogLevel.info, "Replenishing inventory of specified item.");
					System.out.println("-----------------------------------");
					System.out.println("How many units of " + currentProduct + " would you like to replenish? (" + currentInv + ") IN STOCK");
					numOfItems = scanner.nextInt();
					scanner.nextLine();
					
					productDao.incrementInventory(numOfItems, currentProductID);
				}
				else
				{
					logger.log(LogLevel.warning, "INVALID INPUT. Please read/type product names carefully.");
					System.out.println("INVALID INPUT. Please read/type product names carefully.");
				}
				
				
				System.out.println("------------------------------");
				
			}
	//		System.out.println("Type 'shop' to continue shopping. 'checkout' to check out your cart!");
	//		userInput = scanner.nextLine();
			//if 'checkout', checkout method will add the cart to order_history and oh_product_list
			//Iterate through the cart and add the products to the order_history and oh_product_list
			//If the productID is already in OH under the same OrderID, increment OHPL how_many with same orderID and productID as OH
			//Easy!
			
			else if(userInput.equals("checkout"))
			{
				logger.log(LogLevel.info, "'Checkout' entered.");
				if(currentPrice > 0)
				{
					String dateTime = LocalDateTime.now().toString();
					order_history oHistory = new order_history(0, storeID, currentID, dateTime, cartTotal);
					ordersDao.addInstance(oHistory);
					int thisOrderID = ordersDao.findID(oHistory);
					
					
					
					Collections.sort(cart);
					int thisID = 0;
					int howMany = 0;
					boolean change = true;
					
					for(int x = 0; x<cart.size(); x++)
					{
						if(change)
						{
							thisID = cart.get(x);
							change = false;
						}
						if(cart.get(x) == thisID)
						{
							howMany++;
						}
						else
						{
							oh_product_list ohList = new oh_product_list(thisOrderID, thisID, currentID, howMany);
							ohproductsDao.addInstance(ohList);
							howMany = 1;
							thisID = cart.get(x);
							change = true;
						}
						if(x == cart.size()-1 && howMany > 0)
						{
							oh_product_list ohList = new oh_product_list(thisOrderID, thisID, currentID, howMany);
							ohproductsDao.addInstance(ohList);
							change = true;
						}
					}
					logger.log(LogLevel.info, "Items successfuly checked out");
					System.out.println("THANK YOU FOR THE PURCHASE!");
					System.out.println("Returning to the menu.");
					shopHere(currentID, currentName, storeID, storeName);
					
				}
				else
				{
					logger.log(LogLevel.warning, "CART EMPTY: NOTHING TO CHECKOUT");
					System.out.println("NOTHING IN YOUR CART TO CHECKOUT");
				}
				
			}
			else if(userInput.equals("Stores"))
			{
				logger.log(LogLevel.info, "'Stores' entered. Returning to store selection.");
				storeSelect(currentID, currentName);
			}
			
			
			else if(userInput.equals("History"))
			{
				logger.log(LogLevel.info, "'History' entered. Displaying current customer's order history.");
				int thisOrderID = 0;
				int thisProductID = 0;
				for(order_history ohList: ordersDao.getAllInstances())
				{
					if(ohList.getCustomerID() == currentID)
					{
						System.out.println("You bought ---$" + ohList.getTotalCost() + "--- worth of items");
						System.out.println("On " + ohList.getDateTime());
						System.out.println("This order was comprised of the following:");
						thisOrderID = ordersDao.findID(ohList);
					}
					for(oh_product_list ohpList: ohproductsDao.getAllInstances())
					{
						
						for(products product: productDao.getAllInstances())
						{
							thisProductID = productDao.findID(product);
							//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
							if(ohpList.getOrderID() == thisOrderID && thisProductID == ohpList.getProductID())//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
							{
								System.out.println(ohpList.getHowMany() + " units of the " + product.getName());
							}
						}
					}
				}
			}
			
		
			else if(userInput.equals("Cart"))
			{
				logger.log(LogLevel.info, "'Cart' entered. Displaying cart items.");
				
				if(cart.size() > 1)
				{
					String dateTime = LocalDateTime.now().toString();
					//order_history oHistory = new order_history(storeID, currentID, dateTime, cartTotal);
					//ordersDao.addInstance(oHistory);
					//int thisOrderID = ordersDao.findID(oHistory);
					
					
					
					Collections.sort(cart);
					int thisID = 0;
					int howMany = 0;
					int thisProductID = 0;
					boolean change = true;
					
					for(int x = 0; x<cart.size(); x++)//8 8 8 9 9
					{
						if(change)
						{
							thisID = cart.get(x);
							change = false;
						}
						if(cart.get(x) == thisID)
						{
							howMany++;
						}
						else
						{
							for(products product: productDao.getAllInstances())
							{
								thisProductID = productDao.findID(product);
								//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
								if(thisProductID == thisID)//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
								{
									System.out.println(howMany + " units of the " + product.getName() + "s");
								}
							}
							howMany = 1;
							thisID = cart.get(x);
							change = true;
						}
						if(x == cart.size()-1 && howMany > 0)
						{
							
							for(products product: productDao.getAllInstances())
							{
								thisProductID = productDao.findID(product);
								//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
								if(thisProductID == thisID)//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
								{
									System.out.println(howMany + " of the " + product.getName());
								}
							}
						}
					}
				}
				else
				{
					logger.log(LogLevel.warning, "CART EMPTY. Nothing to display.");
					System.out.println("CART IS EMPTY");
				}
				
			}
			else
			{
				logger.log(LogLevel.info, "INVALID INPUT. Please read/type the options carefully.");
				System.out.println("INVALID INPUT. Please read/type the options carefully.");
			}
		
		
		
		}while(userInput != "Quit");
		
		loginOrRegisterHere();
	}
	
	public static String getProductName(int productID)
	{
		for(products product: productDao.getAllInstances())
		{
			if(productID == product.getProductID())//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
			{
				return product.getName();
			}
		}
		
		return "";
		
	}
	
}