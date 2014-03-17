package org.sjitech.myassist.core.beans;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.sjitech.myassist.api.annotation.Unit;

/**
 * @author sji_zhang_x
 *
 */
public class BeanManager {

	/**
	 * resource scanner
	 */
	private static Reflections reflections = new Reflections(
			ConfigurationBuilder.build((Object[]) null));

	/**
	 * get all the class with unit annotation
	 * 
	 * @param filter
	 * 	              xxx.yyy.**
	 * @return
	 */
	public static List<Class<?>> getAllUnitClass() {
		Set<Class<?>> types = reflections.getTypesAnnotatedWith(Unit.class);

		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> type : types) {
			classes.add(type);
		}

		return classes;
	}

	/**
	 * get the unit class's all test method
	 * 
	 * @param type
	 * @return
	 */
	public static Method[] getUnitMethods(Class<?> type) {
		Method[] methods = type.getDeclaredMethods();

		return methods;
	}

	/**
	 * get actual implemented class
	 * sub interface/abstract class/private/protected will be omitted.
	 * 
	 * @param intf
	 * @return
	 */
	public static <T> Class<? extends T> getImplementClass(Class<T> t) {
		Set<Class<? extends T>> subClasses = reflections.getSubTypesOf(t);

		for (Class<? extends T> subClass : subClasses) {
			if (Modifier.isAbstract(subClass.getModifiers())
					|| Modifier.isInterface(subClass.getModifiers())
					|| Modifier.isPrivate(subClass.getModifiers())
					|| Modifier.isProtected(subClass.getModifiers())) {
				continue;
			}
			return subClass;
		}

		return null;
	}
}
