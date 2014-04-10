package org.sjitech.myassist.view.images;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * icon images
 * 
 * @author sji_zhang_x
 *
 */
public class IconSet {

	/**
	 * icons cache map
	 */
	private static final Map<String, Icon> ICONS = new HashMap<String, Icon>();

	/**
	 * find icon images by file name
	 * 
	 * @return
	 */
	private static Icon findIcon(String name) {
		URL url = IconSet.class.getResource(name);
		if (url == null) {
			throw new IllegalArgumentException(name + " is not found.");
		}
		ImageIcon icon = new ImageIcon(url);

		if (icon.getImage() == null) {
			return null;
		}
		return icon;
	}

	/**
	 * @param name
	 * @return
	 */
	public final static Icon get(String name) {
		Icon o = ICONS.get(name);
		if (o != null) {
			return o;
		}

		o = findIcon(name);
		if (o == null) {
			throw new IllegalArgumentException(name + " is not found be as a icon.");
		}
		ICONS.put(name, o);

		return o;
	}
}
