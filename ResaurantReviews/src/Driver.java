import java.util.Scanner;
import models.EnergyDrink;

import java.util.ArrayList;


/*Group Activity Details
- Create a store menu
- Create a product
- Bonus: Present a list of products as well as any products that was added in
*/

public class Driver 
{
	//public - access modifier any other class can access it and call it
	//static - object of the Driver class need not be instantiated to utilize and execute method
	//void - return type. Void doesn't return anything
	//main - Name of the method
	//String[] - string array
	//args - a method variable that contains reference to the string array
	public static void main(String[] args) {
		System.out.println("Hello World");
		String userInput = "";
		//Scanner is a class that we'll use to read the console to get user input
		//lhs scanner - name for the reference
		//rhs new - instantiates a new object
		//rhs Scanner(System.in) - Parameterized Constructor for the Scanner class
		Scanner scanner = new Scanner(System.in);
		
		//Starting Energy Drink List
		ArrayList<EnergyDrink> drinkList = new ArrayList<EnergyDrink>();
		drinkList.add(new EnergyDrink("Red Bull", 2.00));
		drinkList.add(new EnergyDrink("Monster", 3.00));
		
		do 
		{
			System.out.println("Welcome to the Energy Drink Store");
			System.out.println("What would you like to do today?");
			System.out.println("[1] Display List");
			System.out.println("[2] Create energy drink");
			System.out.println("[x] Exit out");
			
			userInput = scanner.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println("The energy drinks in-store are: ");
				for(EnergyDrink currentDrink: drinkList) {
					//System.out.println(currentDrink.getName() + " priced at: $" + currentDrink.price);
					System.out.printf("%s priced at: $%.2f \n", currentDrink.getName(), currentDrink.price);//Prints the price with 2 decimal places
				}
				break;
			case "2":
				//get user drink name
				System.out.println("Enter the new Energy Drink Name: ");
				String newName = scanner.nextLine();
				
				//Get user drink price
				System.out.println("Now enter the new Energy Drink price: ");
				String priceString = scanner.nextLine();
				try {
					double price = Double.parseDouble(priceString);
					if(price > 0) 
					{
						//Energy drink is made
						EnergyDrink newDrink = new EnergyDrink(newName, price);//Make the object
						drinkList.add(newDrink);//Add object to list
					}
					else
					{
						System.out.println("Invalid price");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("INPUT ERROR: " + e.getMessage());
					
				}
				break;
				
			case "x":
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid input, please check the options below, and try again.");
				break;
			}
		} while(!(userInput.equals("x")));
		scanner.close();
	
	}

}
