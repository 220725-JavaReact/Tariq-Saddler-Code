package javaReflectionsDemoPackage;

import java.util.ArrayList;

public class McDonaldsTest {
	
	@Test
	public void Baconator_Should_Be_An_X()
    {
        //Arrange
		ArrayList<String> expectedMenu = new ArrayList<String>();
		expectedMenu.add("Big Mac");
		expectedMenu.add("McDouble");
		expectedMenu.add("Quarter Pounder");
		expectedMenu.add("Baconator");
		expectedMenu.add("McChicken");
		expectedMenu.add("Fries");
        McDonaldsRestaurant McDonalds1 = new McDonaldsRestaurant();

        //Act
        McDonalds1.setMenu(expectedMenu);

        //Assert
        Assertion.Equals(expectedMenu, McDonalds1.getMenu());

    }
	
	@Test(enable = false)
    public void Some_Unit_Test() {
        //Just ignore me
    }
	
	@Test
	public void Drinks_Are_Valid()
    {
		//Arange
		String[] expectedDrinks = {"Coke", "Dr. Pepper", "Sprite", "Fanta Orange"};
		McDonaldsRestaurant McDonalds1 = new McDonaldsRestaurant();
		
		//Act
		McDonalds1.setDrinks(expectedDrinks);
		
		//Assert
		Assertion.arrayEquals(expectedDrinks, McDonalds1.getDrinks());
    }

}
