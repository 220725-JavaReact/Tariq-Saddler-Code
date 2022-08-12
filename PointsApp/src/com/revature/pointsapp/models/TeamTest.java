package com.revature.pointsapp.models;

import com.revature.pointsapp.exceptions.InvalidPointException;
import com.revature.pointsapp.models.Team.PointCategories;
import com.revature.pointsapp.notjunit.Assert;
import com.revature.pointsapp.notjunit.annotations.Test;

public class TeamTest {
	
	@Test
	public void add_Points_Should_Add() {
		// arrange
		Team test = new Team("test");
		// act
		test.addPoints(10);
		//assert
		Assert.equals(10, test.getTotalPoints());
	}
	@Test
	public void add_Points_Should_Add_By_Category() {
		// arrange
		Team test = new Team("test");
		// act
		test.addPoints(PointCategories.DEBUG_TRAINER);
		//assert
		Assert.equals(10, test.getTotalPoints());
	}
	
	@Test
	public void add_Points_Should_Not_Add_Nothing() {
		// arrange
		Team test = new Team("test");
		// call a method wilThrow that runs test.addPoints so we can verify that it throws an exception
		Assert.willThrow(InvalidPointException.class, () -> test.addPoints(0));
		
	}

}
