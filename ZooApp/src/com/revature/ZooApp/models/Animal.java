package com.revature.ZooApp.models;

public class Animal extends Type{
	private Type type;
	private String animalGroup;
	private String funFact;
	private String kingdom;
	private String phylum;
	private String animalClass;
	
//	public Type getType() {
//		return super();
//	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getAnimalGroup() {
		return animalGroup;
	}
	public void setAnimalGroup(String animalGroup) {
		this.animalGroup = animalGroup;
	}
	public String getFunFact() {
		return funFact;
	}
	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}
	
	public String getKingdom() {
		return kingdom;
	}
	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}
	public String getPhylum() {
		return phylum;
	}
	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}
	public String getAnimalClass() {
		return animalClass;
	}
	public void setAnimalClass(String animalClass) {
		this.animalClass = animalClass;
	}
	
	
	
	
	Animal(String T, String ag, String kingdom, String phylum, String animalClass, String ff)
	{
		super(T);
		//type = T;
		animalGroup = ag;
		funFact = ff;
		this.kingdom = kingdom;
		this.phylum = phylum;
		this.animalClass = animalClass;
	}
	
	Animal()
	{
		type = null;
		animalGroup = null;
		funFact = null;
		kingdom = null;
		phylum = null;
		animalClass = null;
	}
	Animal(Animal A)
	{
		this.type = A.type;
		this.animalGroup = A.animalGroup;
		this.funFact = A.funFact;
		this.kingdom = A.kingdom;
		this.phylum = A.phylum;
		this.animalClass = A.animalClass;
	}
	
}
