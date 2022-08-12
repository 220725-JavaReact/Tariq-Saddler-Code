package com.revature.ZooApp.models;

import java.util.ArrayList;



public class Zoo {
	
	private ArrayList<Type> typeList = new ArrayList<Type>();
	private ArrayList<Animal> animalsList = new ArrayList<Animal>();
	private ArrayList<Specific> specificsList = new ArrayList<Specific>();
	
	
	public Zoo(){
		
		Type terrestrial = new Type("Terrestrial");
		typeList.add(terrestrial);
		
		Animal elephant = new Animal("Terrestrial", "Elephant", "Animalia", "Chordata", "Mammalia", "They can live up to 70 years in the wild!");
		animalsList.add(elephant);
		Specific dumbo = new Specific(elephant, "Dumbo", 5, 6.6);
		Specific horton = new Specific(elephant, "Horton", 20, 5000);
		specificsList.add(dumbo);
		specificsList.add(horton);
		
		Animal giraffe = new Animal("Terrestrial", "Giraffe", "Animalia", "Chordata", "Mammalia", "The neck can grow up to 7.9 feet in length");
		animalsList.add(giraffe);
		Specific melmin = new Specific(giraffe, "Melmin", 14, 300);
		Specific gary = new Specific(giraffe, "Gary", 10, 320.3);
		specificsList.add(melmin);
		specificsList.add(gary);
		
		
		Type aquatic = new Type("Aquatic");
		typeList.add(aquatic);
		
		Animal octopus = new Animal("Aquatic", "Octopus", "Animalia", "Mollusca", "Cephalopoda", "Octopi are among the smartest invertebrates");
		animalsList.add(octopus);
		Specific squidward = new Specific(octopus, "Squidward", 30, 50.9);
		Specific octodad = new Specific(octopus, "Octodad", 50, 150.1);
		specificsList.add(octodad);
		specificsList.add(squidward);
		
		Animal whale = new Animal("Aquatic", "Whale", "Animalia", "Chordata", "Mammalia", "These creatures are the largest mammals on earth");
		animalsList.add(whale);
		Specific Pearl = new Specific(whale, "Pearl", 16, 230.3);
		Specific Moby = new Specific(whale, "Moby Dick", 30, 800.2);
		specificsList.add(Pearl);
		specificsList.add(Moby);

		
		Type aerial = new Type("Aerial");
		typeList.add(aerial);
		
		Animal peacock = new Animal("Aerial", "Peacock", "Animalia", "Chordata", "Aves", "These birds look positively marvelous!");
		animalsList.add(peacock);
		Specific shen = new Specific(peacock, "Shen", 40, 51.9);
		Specific george = new Specific(peacock, "George", 9, 34.2);
		specificsList.add(shen);
		specificsList.add(george);
		
		Animal owl = new Animal("Aerial", "Owl", "Animalia", "Chordata", "Aves", "They can see at night with their night vision.");
		animalsList.add(owl);
		Specific blathers = new Specific(owl, "Blathers", 45, 10);
		Specific mrowl = new Specific(owl, "Mr. Owl", 50, 10);
		specificsList.add(blathers);
		specificsList.add(mrowl);
		

		
		Type arborel = new Type("Arborel");
		typeList.add(arborel);
		Animal ape = new Animal("Arborel", "Ape", "Animalia", "Chordata", "Mammalia", "Gorrilas are cool 🙂");
		animalsList.add(ape);
		Specific bonzo = new Specific(ape, "Bonzi Buddy", 23, 1.3);
		Specific donkeykong = new Specific(ape, "Donkey Kong", 43, 222.2);
		specificsList.add(donkeykong);
		specificsList.add(bonzo);
		
		Animal orangutan = new Animal("Arborel", "Orangutan", "Animalia", "Chordata", "Mammalia", "These guys are like super orange!");
		animalsList.add(orangutan);
		Specific lanky = new Specific(orangutan, "Lanky Kong", 30, 190.3);
		Specific forever = new Specific(orangutan, "Forever", 44, 149.3);
		specificsList.add(forever);
		specificsList.add(lanky);
		

		Type amphibious = new Type("Amphibious");
		typeList.add(amphibious);
		
		Animal africanbullfrog = new Animal("Amphibious","African Bullfrog", "Animalia", "Chordata", "Amphibia", "These frogs can live for 35 years in captivity");
		animalsList.add(africanbullfrog);
		Specific datboi = new Specific(africanbullfrog, "Dat Boi", 1000, 45.3);
		Specific Kermit = new Specific(africanbullfrog, "Kermit", 41, 55.2);
		specificsList.add(datboi);
		specificsList.add(Kermit);
		
		Animal cgs = new Animal ("Amphibious", "Chinese Giant Salamander", "Animalia", "Chordata", "Amphibia", "These guys are too big, they need to get smaller");
		animalsList.add(cgs);
		Specific jarjar = new Specific(cgs, "Jar Jar Binks", 38, 160.7);
		Specific mordin = new Specific(cgs, "Mordin Solus", 30, 180.3);
		specificsList.add(jarjar);
		specificsList.add(mordin);
				
		
	}


	public ArrayList<Type> getTypeList() {
		return typeList;
	}


	public ArrayList<Animal> getAnimalsList() {
		return animalsList;
	}


	public ArrayList<Specific> getSpecificsList() {
		return specificsList;
	}
	
	
}
