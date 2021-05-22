package com.rest.address;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private int id;
	
	public Contact() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phone = "";
	}
	
	public Contact(int id) {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phone = "";
		this.id = id;
	}
	
	public Contact(String firstName, String lastName, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}
	
	public Contact(String firstName, String lastName, String address, String phone, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		this.id = id;
	}
	
    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        
        try {
            obj.put("first_name", this.firstName);
            obj.put("last_name", this.lastName);
            obj.put("address", this.address);
            obj.put("phone", this.phone);
            obj.put("id", this.id);
        } catch (JSONException e) {
            e.getMessage();
        }
        
        return obj;
    }
	
	@Override
	public String toString() {
		return "Contact [FIRST NAME: " + this.firstName +
				", LAST NAME: " + this.lastName + ", ADDRESS: " + this.address + 
				", PHONE: " + this.phone + ", ID: " + this.id + "]";
	}
	

}
