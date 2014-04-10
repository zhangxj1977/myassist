package org.sjitech.myassist.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * logic name or comment for class/method/field
 * this can be shown on design form and help you
 * know there's mean quickly.
 * 
 * @author sji_zhang_x
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Description {

	/**
	 * short description
	 * 
	 * @return
	 */
	String value();

	/**
	 * detail description
	 * 
	 * @return
	 */
	String detail() default "";
}
