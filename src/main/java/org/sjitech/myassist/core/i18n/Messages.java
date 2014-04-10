package org.sjitech.myassist.core.i18n;

import java.util.ResourceBundle;

import org.sjitech.myassist.core.ApplicationException;

/**
 * @author sji_zhang_x
 *
 */
public final class Messages {

	/**
	 * @param self
	 * @param key
	 * @return
	 */
	public final static String getString(String key) {
		ResourceBundle rb = ResourceBundle.getBundle("messages");
		if (rb == null) {
			throw new ApplicationException("messages.properties is not exists.");
		}
		String msg = rb.getString(key);
		if (msg == null) {
			msg = "!" + key + "!";
		}
		return msg;
	}
}
