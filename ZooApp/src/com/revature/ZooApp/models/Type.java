package com.revature.ZooApp.models;

public class Type {
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	Type(String T)
	{
		typeName = T;
	}
	
	Type()
	{
		typeName = null;
	}
}
