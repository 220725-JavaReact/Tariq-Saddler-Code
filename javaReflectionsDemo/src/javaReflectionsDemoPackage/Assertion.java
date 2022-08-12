package javaReflectionsDemoPackage;

import java.util.ArrayList;

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
	
	

}
