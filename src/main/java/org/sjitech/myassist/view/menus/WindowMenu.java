package org.sjitech.myassist.view.menus;

import javax.swing.JMenu;

import bibliothek.gui.DockFrontend;

/**
 * @author sji_zhang_x
 *
 */
@SuppressWarnings("serial")
public class WindowMenu extends JMenu {

	/** the frontend which is used to show or hide <code>Dockable</code>s */
	private DockFrontend frontend;

	/**
	 * @param frontend
	 */
	public WindowMenu(DockFrontend frontend) {
		this.frontend = frontend;
		setText("ウィンドウ(W)");
		setMnemonic('W');

		initViewMenu();
	}
	
	/**
	 * show view menu
	 */
	private void initViewMenu() {
		add(new ViewMenu(frontend));
	}
}
