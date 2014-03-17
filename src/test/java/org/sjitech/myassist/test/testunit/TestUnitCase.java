package org.sjitech.myassist.test.testunit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sjitech.myassist.api.annotation.Note;
import org.sjitech.myassist.core.beans.BeanManager;
import org.sjitech.myassist.test.testunit.bo.PersonBO;
import org.sjitech.myassist.test.testunit.dto.Address;
import org.sjitech.myassist.test.testunit.dto.PersonInfo;
import org.sjitech.myassist.unit.cases.Params;
import org.sjitech.myassist.unit.cases.UnitCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

public class TestUnitCase {

	static Logger log = LoggerFactory.getLogger(TestUnitCase.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUnitCase() {
		UnitCase t = new UnitCase();
		t.setUnitCaseNo("A001-0001");
		t.setUnitClassName(PersonBO.class.getName());
		t.setMethodName("addPerson");

		PersonInfo p = new PersonInfo();
		p.setName("personA1");
		p.setAge(30);

		Address addr = new Address();
		addr.setCountry("Japan");
		addr.setCity("Tokyo");
		addr.setBanchi("1-1");
		p.setHomeAddress(addr);

		List<Address> workAddr = new ArrayList<Address>();
		addr = new Address();
		addr.setCountry("Japan");
		addr.setCity("Chiba");
		addr.setBanchi("1-2");
		workAddr.add(addr);
		addr = new Address();
		addr.setCountry("China");
		addr.setCity("Nanjing");
		addr.setBanchi("Aoti-1");
		workAddr.add(addr);
		p.setWorkAddress(workAddr);

		Params param = new Params();
		param.setContext(p);	
		t.setParams(param);

		XStream xs = new XStream();
		String s = xs.toXML(t);
		System.out.println(s);

		UnitCase newT = (UnitCase) xs.fromXML(s);
		s = xs.toXML(newT);
		System.out.println(s);
	}
	
	@Test
	public void testBeanManager() {

		List<Class<?>> all = BeanManager.getAllUnitClass();
		
		for (Class<?> c : all) {
			System.out.println(c);
			Method[] methods = BeanManager.getUnitMethods(c);
			
			for (Method method : methods) {
				String methodName = method.getName();
				Note note = method.getAnnotation(Note.class);
				Class<?>[] paramTypes = method.getParameterTypes();
				Class<?> returnType = method.getReturnType();
				
				log.debug("method=" + methodName);
				if (note != null) {
					log.debug("note=" + note.value());
				}
				for (Class<?> param : paramTypes) {
					if (param.isInterface()) {
						Class<?> implClass = BeanManager.getImplementClass(param);
						log.debug("interface=" + param.getName());
						log.debug("implement=" + implClass.getName());
					} else {
						log.debug("param=" + param.getName());
					}
				}
				log.debug("return=" + returnType.getName());
			}
		}
	}
}
