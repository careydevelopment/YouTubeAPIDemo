package com.careydevelopment.zillowdemo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {
	
	@Size(min=5, max=64, message="Address must be between 5 and 64 characters")
	private String address;
	
	@Pattern(regexp="^[0-9]{5}(?:-[0-9]{4})?$", message="Please enter a 5-digit zip code")
	private String zip;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
