package org.sjitech.myassist.core.ui;

import java.util.Map;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * @author zhangxj
 *
 */
public final class ResourceManager {

	/**
	 * UIFonts reset
	 *
	 * @param name
	 * @param style
	 * @param size
	 */
	public final static void resetUIFont(String name, int style, int size) {

		for (Map.Entry<Object, Object> entry : UIManager.getDefaults()
				.entrySet()) {
			Object key = entry.getKey();
			Object value = UIManager.get(key);
			if (value != null && value instanceof FontUIResource) {
				FontUIResource f = new FontUIResource(name, style, size);
				UIManager.put(key, f);
			}
		}

	}

	/**
	 * reset ui font size
	 *
	 * @param size
	 */
	public final static void resetUIFontSize(int size) {

		for (Map.Entry<Object, Object> entry : UIManager.getDefaults()
				.entrySet()) {
			Object key = entry.getKey();
			Object value = UIManager.get(key);
			if (value != null && value instanceof FontUIResource) {
				FontUIResource fr = (FontUIResource) value;
				FontUIResource f = new FontUIResource(fr.getFamily(), fr.getStyle(), size);
				UIManager.put(key, f);
			}
		}

	}
}
