package org.sjitech.myassist.test.testunit.dto;

public abstract class MyLive implements Live {

	@Override
	public Address moveTo(String banchi) {

		Address addr = new Address();
		addr.setCountry("Japan");
		addr.setCity("Tokyo");
		addr.setBanchi(banchi);
		
		return addr;
	}

}
