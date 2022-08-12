package javaReflectionsDemoPackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import java.lang.reflect.Field;

public class demoMain {
	
	public static void main(String[] args) {
		
		
//		McDonaldsRestaurant McDonalds1 = new McDonaldsRestaurant();
//		
//		ArrayList<String> menuItems = new ArrayList<String>();
//		menuItems.add("Big Mac");
//		menuItems.add("McDouble");
//		menuItems.add("Quarter Pounder");
//		menuItems.add("Baconator");
//		menuItems.add("McChicken");
//		menuItems.add("Fries");
//		
//		
//		McDonalds1.setMenu(menuItems);
//		
//		System.out.println(McDonalds1.getMenu());
		
		
		
		System.out.println("Unit testing starting...");
		
		System.out.println("--------------------------");
		McDonaldsTest McDonaldsTest = new McDonaldsTest();

		//Reflection selecting every method and running it
		Class McDonaldsTestClass = McDonaldsTest.class;
		
		//Counter
		int totalUnitTests = 0; //Will count how many unit tests we are running
		int ignoredUnitTests = 0;
		int passedUnitTests = 0;
		int failedUnitTests = 0;

		Method[] McDonaldsTestMethods = McDonaldsTestClass.getDeclaredMethods();

		//Foreach loop
		for (Method method : McDonaldsTestMethods) {
			
			if (method.isAnnotationPresent(Test.class)) {
				totalUnitTests++;
				Test test = method.getAnnotation(Test.class);

				//It will only run this method invoke if the metadata "enabled" in our Test annotation is set to true
				if (test.enable()) {
					System.out.println(method.getName());
					try {
						//Grabs the return result of that method
						try {
							method.invoke(McDonaldsTest);
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

}
