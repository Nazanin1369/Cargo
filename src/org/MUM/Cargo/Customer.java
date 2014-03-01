package org.MUM.Cargo;

public class Customer 
{
	String name;
	CustomerRole role;
	
	Customer(String name)
	{
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CustomerRole getRole() {
		return role;
	}
	public void setRole(CustomerRole role) {
		this.role = role;
	}
	
}
