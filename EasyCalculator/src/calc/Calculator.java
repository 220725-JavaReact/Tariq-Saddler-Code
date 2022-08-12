package calc;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Calculator {
	
	public static double add(double input, double input2)
	{
		
		double sum = input + input2;
		logging.writeToFile(logging.logLevel.info + ": You did addition at ");
		logging.writeToFile(logging.logLevel.info + ": You did something at ");
		
		return sum;
	}
	
	public static double subtract(double num1, double num2)
	{
		
		double difference = num1 - num2;
		return difference;
	}
	
	public static double multiply(double num1, double num2)
	{
		
		double product = num1 * num2;
		return product;
	}
	
	public static double divide(double num1, double num2)
	{
		double quotient = 0.0;
		try {
			quotient = num1 / num2;
			
		}
		catch(Exception d){
			logging.writeToFile(logging.logLevel.error + " any error");
		}
		
		return quotient;
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
	//userInput = scanner.nextLine();
		System.out.println("Wanna use the calculator?");
		String mathType = scanner.nextLine();
		
		do{
			
			System.out.println("What kind of math do you want to do");
			String math = scanner.nextLine();
			System.out.println("Give us the 1st number");
			String stringNum1 = scanner.nextLine();
			System.out.println("Give us the 2nd number");
			String stringNum2 = scanner.nextLine();
			
			
			
			double num1 = Double.parseDouble(stringNum1);
			double num2 = 0.0;
			
			try {
				num2 = Double.parseDouble(stringNum2);
			}
			catch(Exception e)
			{	
				logging.writeErrorToFile(logging.logLevel.error + ": SOME SORT OF ERROR HAPPENED AT ");
				logging.writeErrorToFile(logging.logLevel.error + ": SOME SORT OF ERROR HAPPENED AT ");
				//logging.writeToFile(logging.logLevel.info + ": You did addition at ");
			}
			//System.out.println(mathType);
			//System.out.println(num1);
			//System.out.println(num2);
			//System.out.println("The sum is: " + add(num1, num2));
			
			switch(math)
			{
				case "add": try {
					
					System.out.println("The sum is: " + add(num1, num2));
				}
				catch(Exception e) {
					//System.out.println("ERROR HAPPENING NOW");
					//logging.writeErrorToFile(logging.logLevel.error + ": SOME SORT OF ERROR HAPPENED AT ");
				}
				break;
				
				case "subtract": System.out.println("The difference is: " + subtract(num1, num2));
				break;
				
				case "multiply": System.out.println("The product is: " + multiply(num1, num2));
				break;
					
				case "quotient": 
					if(num2 == 0)
					{
						
					}
					else
					{
						System.out.println("The quotient is: " + divide(num1, num2));
					}
					
				break;
				
			}
			
//			if(math == "add")
//			{
//				System.out.println("The sum is: " + add(num1, num2));
//			}
//			if(math == "subtract")
//			{
//				System.out.println("The difference is: " + subtract(num1, num2));
//			}
//			if(math == "multiply")
//			{
//				multiply(num1, num2);
//			}
//			if(math == "divide")
//			{
//				divide(num1, num2);
//				
//			}
			
			
			//mathType = scanner.nextLine();
		
	
		}while(mathType != "x");
	
	}

}
