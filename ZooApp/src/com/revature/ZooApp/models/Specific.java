package com.revature.ZooApp.models;

public class Specific extends Animal{
	private Type type;
//	private Animal animalGroup;
//	private Animal funFact;
	private String animalName;
	private int age;
	private double weight;
	private Animal animal;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getAnimalGroup() {
		return super.getAnimalGroup();
	}
//	public void setAnimalGroup(Animal animalGroup) {
//		this.animalGroup = animalGroup;
//	}
	public String getFunFact() {
		return super.getFunFact();
	}
//	public void setFunFact(Animal funFact) {
//		this.funFact = funFact;
//	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	Specific(Animal animal, String an, int age, double weight)
	{
		super(animal);
		animalName = an;
		this.age = age;
		this.weight = weight;
	}
	
	
}
