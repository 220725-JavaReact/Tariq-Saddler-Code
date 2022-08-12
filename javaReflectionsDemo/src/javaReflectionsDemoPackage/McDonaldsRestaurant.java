package javaReflectionsDemoPackage;

import java.util.ArrayList;

public class McDonaldsRestaurant {
	
	private ArrayList<String> menuItems = new ArrayList<String>();
	private String[] drinks;
	
	private String address;
	
	public ArrayList<String> getMenu()
	{
		return menuItems;
	}
	
	public void setMenu(ArrayList<String> menuItems)
	{
		//int x = 0;
		for(int i = 0; i < menuItems.size(); i++)
		{
			this.menuItems = menuItems;
			if(menuItems.get(i) == "Whopper" || menuItems.get(i) == "Baconator")
			{
				this.menuItems.set(i, "X");
				//x--;
				
			}
			else
			{
				this.menuItems.set(i, menuItems.get(i));
			}
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String[] getDrinks()
	{
		return drinks;
	}

	public void setDrinks(String[] drinks)
	{
		this.drinks = drinks;
	}

}
