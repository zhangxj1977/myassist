/**
 * 
 */
package org.sjitech.myassist.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * identify the class is a context.
 * it can be as a param or invoke result
 * 
 * @author sji_zhang_x
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Context {

}
