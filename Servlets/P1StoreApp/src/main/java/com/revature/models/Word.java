package com.revature.models;

public class Word {
	private int wordID;
	private int length;
	private String wordName;
	private boolean chosen;
	
	public Word(int length, String wordName)
	{
		//this.wordID = wordID;
		this.length = length;
		this.wordName = wordName;
	}
	
	public Word(int wordID, int length, String wordName, boolean chosen)
	{
		this.wordID = wordID;
		this.length = length;
		this.wordName = wordName;
		this.chosen = chosen;
	}
	
	public int getWordID() {
		return wordID;
	}
	public void setWordID(int wordID) {
		this.wordID = wordID;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	
	
}
