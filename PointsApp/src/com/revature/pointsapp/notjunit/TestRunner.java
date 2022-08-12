package com.revature.pointsapp.notjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.pointsapp.models.TeamTest;
import com.revature.pointsapp.notjunit.annotations.Test;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<TeamTest> obj = TeamTest.class;
		System.out.println("Running tests...");
		
		for(Method method: obj.getDeclaredMethods()) {
			// check if annotation is present
			if(method.isAnnotationPresent(Test.class)) {
				try {
					System.out.println("Testing method: " + method.getName());
					method.invoke(obj.newInstance());
					System.out.println("Test passed");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// if this gets thrown it means our test failed
					System.out.println("Test failed" + e.getTargetException());
					//e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
