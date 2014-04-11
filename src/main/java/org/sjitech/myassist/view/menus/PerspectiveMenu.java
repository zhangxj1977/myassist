package org.sjitech.myassist.view.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.sjitech.myassist.view.images.IconSet;

/**
 * @author sji_zhang_x
 *
 */
public class PerspectiveMenu {

	/** singleton */
	private static PerspectiveMenu instance = null;
	
	/** for toolbar popupmenu */
	private JPopupMenu popupMenu;

	/** for window menu */
	private JMenu windowMenu;

	/**
	 * @return
	 */
	public static synchronized PerspectiveMenu instance() {
		if (instance == null) {
			instance = new PerspectiveMenu();
		}
		return instance;
	}

	/**
	 * @return
	 */
	protected List<JMenuItem> getPerspectiveList() {
		List<JMenuItem> list = new ArrayList<JMenuItem>();

		JMenuItem itemJavaUnit = new JMenuItem("iUnit");
		itemJavaUnit.setIcon(IconSet.get("unit_perspective.gif"));
		list.add(itemJavaUnit);

		return list;
	}

	/**
	 * @return
	 */
	public final JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			List<JMenuItem> list = getPerspectiveList();
			for (JMenuItem item : list) {
				popupMenu.add(item);
			}
		}

		return popupMenu;
	}

	/**
	 * @return
	 */
	public final JMenu getWidowMenu() {
		if (windowMenu == null) {
			windowMenu = new JMenu("ペースペクティブを開く(O)");
			windowMenu.setMnemonic('O');
			List<JMenuItem> list = getPerspectiveList();
			for (JMenuItem item : list) {
				windowMenu.add(item);
			}
		}

		return windowMenu;
	}
}
