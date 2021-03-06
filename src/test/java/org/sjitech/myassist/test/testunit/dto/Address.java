package org.sjitech.myassist.test.testunit.dto;

import org.sjitech.myassist.api.annotation.Description;


public class Address {

	@Description("国")
	private String country = null;
	
	@Description("都市")
	private String city = null;
	
	@Description("番地")
	private String banchi = null;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBanchi() {
		return banchi;
	}

	public void setBanchi(String banchi) {
		this.banchi = banchi;
	}

}
