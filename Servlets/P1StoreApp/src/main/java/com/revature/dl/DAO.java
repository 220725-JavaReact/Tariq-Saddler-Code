package com.revature.dl;

public interface DAO<T> {
	void addInstance(T newInstance);
	void markSecretWord();
	void unMarkSecretWord();
	T findSecretWord();
	
}
 
