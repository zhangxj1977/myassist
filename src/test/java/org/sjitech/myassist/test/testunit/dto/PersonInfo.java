package org.sjitech.myassist.test.testunit.dto;

import java.util.List;

import org.sjitech.myassist.api.annotation.Description;

public class PersonInfo {

	@Description("名前")
	private String name = null;
	
	@Description("年齢")
	private int age = 0;
	
	@Description("家庭住所")
	private Address homeAddress = null;

	@Description("勤務先住所")
	private List<Address> workAddress = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public List<Address> getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(List<Address> workAddress) {
		this.workAddress = workAddress;
	}

}
