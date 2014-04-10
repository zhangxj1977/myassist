package org.sjitech.myassist.core.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.sjitech.myassist.core.ApplicationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @author sji_zhang_x
 *
 */
public class ClassUtils {

	/**
	 * resource scanner
	 */
	private static Reflections reflections = new Reflections(
			ConfigurationBuilder.build((Object[]) null));

	/**
	 * given the base package name and list all the classes of the package
	 * 
	 * @param filter
	 * 	              xxx.yyy.**
	 * @return
	 */
	public static List<Class<?>> getClassWith(String filter) {
		ClassPathScanningCandidateComponentProvider scanner = 
				new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new TypeFilter() {
			public boolean match(MetadataReader metadataReader,
					MetadataReaderFactory metadataReaderFactory)
					throws IOException {
				return true;
			}
		});

		String regFilter = "**";
		if (null != filter && !"".equals(filter.trim())) {
			regFilter = filter;
		}

		List<Class<?>> classes = new ArrayList<Class<?>>();
		try {
			for (BeanDefinition beanDefinition : scanner
					.findCandidateComponents(regFilter)) {
				classes.add(Class.forName(beanDefinition.getBeanClassName()));
			}
		} catch (Exception e) {
			throw new ApplicationException(e);
		}

		return classes;
	}

	/**
	 * get all the class with annotation
	 * 
	 * @param annotation
	 * @return
	 */
	public static List<Class<?>> getClassWith(Class<? extends Annotation> annotation) {
		Set<Class<?>> types = reflections.getTypesAnnotatedWith(annotation);

		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> type : types) {
			classes.add(type);
		}

		return classes;
	}

	/**
	 * get the class's all test method
	 * public/protected/private
	 * 
	 * @param type
	 * @return
	 */
	public static Method[] getMethods(Class<?> type) {
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
