package com.revature.P0StoreApp.test;

import java.util.ArrayList;

import com.revature.P0StoreApp.dl.DAO;
import com.revature.P0StoreApp.dl.OrdersDAO;
import com.revature.P0StoreApp.models.customer;
import com.revature.P0StoreApp.models.order_history;

public class P0StoreAppTest {
	private static DAO<order_history> ordersDao = new OrdersDAO();
	
	@Test
	public void Customer_UN_Setter()
    {
        //Arrange
		customer newCustomer = new customer("Mark", "Moore", "Markus", "password", "mark.moore@revature.net");
		customer expectedCustomer = new customer("Mark", "Moore", "MyNameMark", "password", "mark.moore@revature.net");
        //Act
        newCustomer.setC_un("MyNameMark");

        //Assert
        Assertion.customerUNEquals(newCustomer, expectedCustomer);

    }
	
	@Test
    public void Customer_FName_Capitalize() {
        //Arrange
		customer newCustomer = new customer("Mark", "Moore", "Markus", "password", "mark.moore@revature.net");
		customer expectedCustomer = new customer("Mark", "Moore", "Markus", "password", "mark.moore@revature.net");
		
		//Act
		newCustomer.setFname("mark");
		
		//Assert
		Assertion.customerFNameEquals(newCustomer, expectedCustomer);
    }
	
	@Test
    public void Customer_FLame_Capitalize() {
        //Arrange
		customer newCustomer = new customer("Mark", "Moore", "Markus", "password", "mark.moore@revature.net");
		customer expectedCustomer = new customer("Mark", "Moore", "Markus", "password", "mark.moore@revature.net");
		
		//Act
		newCustomer.setLname("moore");
		
		//Assert
		Assertion.customerLNameEquals(newCustomer, expectedCustomer);
    }
	
	@Test(enable = false)
	public void Another_Unit_Test()
    {
		//Arange
	
		
		//Act
		
		
		//Assert
		
    }
	

}
