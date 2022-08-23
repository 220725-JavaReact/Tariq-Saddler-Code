package com.revature.P0StoreApp.test;

import java.util.ArrayList;

import com.revature.P0StoreApp.models.customer;
import com.revature.P0StoreApp.models.order_history;

public class Assertion {
	public static void Equals(ArrayList<String> expected, ArrayList<String> actual)
    {
		
		boolean flag = false;
		for(int i = 0; i < actual.size(); i++)
		{
			
			//System.out.println(actual.get(i));
			if(actual.get(i) == "X" && expected.get(i) == "X")
			{
				flag = true;
				break;
			}
		}
		//return false;
		Evaluate(flag, "Fail");
        //return expected == actual;
    }
	
	
	public static void arrayEquals(String[] expected, String[] actual)
    {
		Evaluate(expected == actual, "Fail");//use .equals
    }
	
	private static void Evaluate(boolean condition, String message)
	{
		if(!condition)
		{
			throw new AssertionError(message);
		}
	}
	
	public static void customerUNEquals(customer expected, customer actual)
	{
		boolean flag = false;
		if(actual.getC_un().equals(expected.getC_un())){
			flag = true;
			
		}
		
		Evaluate(flag, "Fail");
	}
	
	public static void customerFNameEquals(customer expected, customer actual)
	{
		boolean flag = false;
		if(actual.getFname().equals(expected.getFname())){
			flag = true;
			
		}
		
		Evaluate(flag, "Fail");
	}
	
	public static void customerLNameEquals(customer expected, customer actual)
	{
		boolean flag = false;
		if(actual.getLname().equals(expected.getLname())){
			flag = true;
			
		}
		
		Evaluate(flag, "Fail");
	}

	public static void orderHistoryID(order_history expected, order_history actual)
	{
		
	}
}
