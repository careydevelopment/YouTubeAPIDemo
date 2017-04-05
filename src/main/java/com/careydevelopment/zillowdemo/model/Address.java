package com.careydevelopment.zillowdemo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {
	
	@Size(min=5, max=64, message="Street Address must be between 5 and 64 characters")
	private String streetAddress;
	
	@Pattern(regexp="^[0-9]{5}(?:-[0-9]{4})?$", message="Please enter a 5-digit zip code")
	private String zip;


	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
