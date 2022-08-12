package com.revature.pointsapp.storage;

import com.revature.pointsapp.models.Team;

public class TeamList {
	private Team[] backingArray;
	private int lastIndex;
	
	// set the intial values of our arrayList
	public TeamList() {
		backingArray = new Team[2];
		lastIndex = 0;
	}
	
	public void add(Team newTeam)
	{
		// what if the arraylist has reached max cap?
		if (lastIndex == backingArray.length) {
			int newSize = (int) (lastIndex * 1.5);
			Team[] newBacking = new Team[newSize];
			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.length);
			backingArray=newBacking;
		}
		backingArray[lastIndex] = newTeam;
		lastIndex++;
	}
	public Team[] getAllElements() {
		return backingArray;
	}
 }
