package org.sjitech.myassist.test.testunit.bo;

import org.sjitech.myassist.test.testunit.dto.PersonInfo;

public interface IPerson {

	int addPerson(PersonInfo person);
	
	boolean deletePerson(String name);
}
