package com.revature.ZooApp.ui;

import java.util.Scanner;

import com.revature.ZooApp.models.Animal;
import com.revature.ZooApp.models.Specific;
import com.revature.ZooApp.models.Type;
import com.revature.ZooApp.models.Zoo;
import com.revature.ZooApp.util.Logger;
import com.revature.ZooApp.util.Logger.LogLevel;

public class Menu {
	
	public static Logger logger = Logger.getLogger();
	public static void open() 
	{
		logger.log(LogLevel.info, "Starting the program...");
		Zoo z = new Zoo();
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		do {
			System.out.println("Welcome to the Zoo!");
			System.out.println("[1] View information about animals");
			System.out.println("[x] Exit");
			
			//Structure:
			//Type > Animal > Specific Animal
			
			//Type: String typeName
			//Animal: Type type, String animalGroup, String funFact
			//Specific: String animalName, int animalAge, Type type, Animal animalGroup, double weight
			
				userInput = scanner.nextLine();
				switch(userInput)	
				{
				case "1":
					//Display a list of type of animals (terrestrial, aquatic, arborial, aerial, amphibious)
					//User selects one
					//They select specific animal from a list (Ie: Gorilla, lion, killer whale, etc.) depending on the type
					//Then a list of names of the individual animals that are at the zoo is displayed
					//User then selects a name and the data displays
					TypesofAnimals(z);
					
					break;
		
				case "x":
					System.out.println("See you next time!");
					break;
				default:
					logger.log(LogLevel.warning, "INVALID INPUT for main menu");
					System.out.println("Invalid input");
					break;
				}
			
			
		}while (!userInput.equals("x"));
		
		logger.log(LogLevel.info, "Exiting app");
	}
	
	
	public static void TypesofAnimals(Zoo Z)
	{
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		do {
			logger.log(LogLevel.info, "Printing types of animals...");
			for(Type T: Z.getTypeList())
			{
				System.out.println(T.getTypeName());
			}
			
			System.out.println("---------------------------------------------------");
			System.out.println("Which type of animal would you like to select from?");
			System.out.println("---------------------------------------------------");
			
			userInput = scanner.nextLine();
			for(Type T: Z.getTypeList())
			{
				if(userInput.equals(T.getTypeName()))
				{
					AnimalGroupings(T, Z);
					return;
				}
			}
			logger.log(LogLevel.warning, "INVALID INPUT for Type of Animal");
			System.out.println("Invalid Input! Press enter to continue...");
			scanner.nextLine();
			
		}while(!userInput.equals("x"));
	}
	
	public static void AnimalGroupings(Type T, Zoo Z)
	{
		
		logger.log(LogLevel.info, "Printing species names of specified type...");
		for(Animal A: Z.getAnimalsList())
		{
			if(A.getTypeName().equals(T.getTypeName()))
			{
				//System.out.println("In the if-statement");
				System.out.println(A.getAnimalGroup());
				//specificanimal call
			}
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("Which of these animal groups would you like to see?");
		System.out.println("---------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		userInput = scanner.nextLine();
		
		for(Animal A: Z.getAnimalsList())
		{
			if(userInput.equals(A.getAnimalGroup()))
			{
				SpecificAnimals(A, Z);
				return;
			}
		}
		logger.log(LogLevel.warning, "INVALID INPUT for Name of Species");
		System.out.println("Invalid Input! Press enter to continue...");
		scanner.nextLine();
		return;
		
		
	}
	
	public static void SpecificAnimals(Animal A, Zoo Z)
	{
		logger.log(LogLevel.info, "Printing the information of our Zoo animals");
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Kingdom: " + A.getKingdom() + ", Phylum: " + A.getPhylum() + ", Class: " + A.getAnimalClass());
		System.out.println("FUN FACT: " + A.getFunFact());
		//System.out.println("In the Method SPECIFIC");
		for(Specific S: Z.getSpecificsList())
		{
			if(S.getAnimalGroup().equals(A.getAnimalGroup()))
			{
				System.out.println("--------------------------");
				//System.out.println("In the if-statement SPECIFIC");
				System.out.println(S.getAnimalName() +" the " + S.getAnimalGroup() + ": ");
				System.out.println("Weight: " + S.getWeight() + " lbs");
				System.out.println("Age: " + S.getAge());
				System.out.println("--------------------------");
			}
		}
		System.out.println("Press enter to return to the main menu.");
		scanner.nextLine();
		return;
		
	}
	
	
	
	
}


