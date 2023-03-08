package com.caresoft.models;

public class User {
    protected Integer id;
    protected int pin;
    
    // CONSTRUCTOR //
    public User(Integer id) {
    	this.id = id;
    }
    
    // GETTERS //
	public Integer getId() {
		return id;
	}
	public int getPin() {
		return pin;
	}
	
	// SETTERS //
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}