/**
 * 
 */
package org.sjitech.myassist.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * identify the class is a test unit. 
 * it can be auto scanned by the designer
 * 
 * @author sji_zhang_x
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Unit {

	/**
	 * short description
	 * 
	 * @return
	 */
	String value() default "";

}
