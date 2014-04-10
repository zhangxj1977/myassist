package org.sjitech.myassist.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.sjitech.myassist.Application;

/**
 * @author sji_zhang_x
 *
 */
@SuppressWarnings("serial")
public class FileMenu extends JMenu implements ActionListener {

	private Application application;

	/**
	 * @param frontend
	 */
	public FileMenu(Application application) {
		this.application = application;
		setText("ファイル(F)");
		setMnemonic('F');
		initMenuItems();
	}

	/**
	 * 
	 */
	private void initMenuItems() {
		JMenuItem mnuItemQuit = new JMenuItem("終了(X)");
		mnuItemQuit.setMnemonic('X');
		mnuItemQuit.setActionCommand("quit");
		mnuItemQuit.addActionListener(this);

		add(mnuItemQuit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if ("quit".equals(command)) {
			application.shutdown();
		}
	}
}
