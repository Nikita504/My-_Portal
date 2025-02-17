package com.java.jquery.model;

import java.io.Serializable;

public class Customer implements Serializable{
    private String firstname;
    private String lastname;
    private int employeeId;
     
    public Customer(){}
     
    public Customer(String firstname, String lastname ,int employeeId){
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeId=employeeId;
    }
     
    // firstname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
     
    // lastname
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
    
}