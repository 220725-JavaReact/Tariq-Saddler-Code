package com.revature.restrev.models;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrinksTest {

	@Test//This annotation tells the compiler that this is a test
	void setPriceShouldSet()
	{
		//Arrange
		EnergyDrink test = new EnergyDrink();
		double testPrice = 1;
		
		//Act
		test.setPrice(testPrice);
		
		//Assert
		assertEquals(testPrice, test.getPrice());
		
		
	}

}
