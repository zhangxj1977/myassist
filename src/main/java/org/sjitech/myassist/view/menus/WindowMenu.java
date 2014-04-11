package org.sjitech.myassist.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		JMenuItem item = new JMenuItem();
		item.setText("新規ウィンドウ(N)");
		item.setMnemonic('N');
		add(item);
		item = new JMenuItem();
		item.setText("ツールバーの非表示(T)");
		item.setMnemonic('T');
		add(item);
		addSeparator();

		add(PerspectiveMenu.instance().getWidowMenu());
		add(new ViewMenu(frontend));
	}
}
