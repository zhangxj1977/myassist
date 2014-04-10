package org.sjitech.myassist.test.testunit.bo;

import java.util.ArrayList;
import java.util.List;

import org.sjitech.myassist.api.annotation.Description;
import org.sjitech.myassist.test.testunit.dto.Address;
import org.sjitech.myassist.test.testunit.dto.Live;
import org.sjitech.myassist.test.testunit.dto.PersonInfo;

public class PersonBO implements IPerson {

	@Description(value="要員追加処理", detail="add person with person object")
	public int addPerson(PersonInfo person) {
		return 1;
	}

	@Description("要員削除処理")
	public boolean deletePerson(String name) {
		return true;
	}

	@Description("引越し履歴")
	public List<Address> liveHistory(Live newLive) {
		List<Address> hist = new ArrayList<Address>();
		
		hist.add(newLive.moveTo("2-3"));
		hist.add(newLive.moveTo("2-4"));
		
		return hist;
	}
}
