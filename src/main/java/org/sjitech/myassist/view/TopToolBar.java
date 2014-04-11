package org.sjitech.myassist.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JToolBar;

import org.sjitech.myassist.Application;
import org.sjitech.myassist.view.images.IconSet;
import org.sjitech.myassist.view.menus.PerspectiveMenu;
import org.sjitech.myassist.view.swing.JRolloverButton;
import org.sjitech.myassist.view.swing.JSplitButton;
import org.sjitech.myassist.view.swing.JToggleButtonEx;

/**
 * @author sji_zhang_x
 *
 */
@SuppressWarnings("serial")
public class TopToolBar extends JToolBar {

	/** */
	Application application;

	/**
	 * @param application
	 */
	public TopToolBar(Application application) {
		this.application = application;
		init();
	}

	/**
	 * 
	 */
	private void init() {
		setBorderPainted(false);
		setFloatable(false);
		setLayout(new BorderLayout());
		JToolBar left = new JToolBar();
		left.setFloatable(false);
		left.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
		add(left, BorderLayout.CENTER);
		left.addSeparator(new Dimension(3, 25));
		JRolloverButton btnNewUnit = new JRolloverButton();
		btnNewUnit.setIcon(IconSet.get("newclass_wiz.gif"));
		btnNewUnit.setPreferredSize(new Dimension(25, 25));
		left.add(btnNewUnit);
		left.addSeparator(new Dimension(1, 1));

		JToggleButtonEx btnNewUnit2 = new JToggleButtonEx();
		btnNewUnit2.setIcon(IconSet.get("newclass_wiz.gif"));
		btnNewUnit2.setPreferredSize(new Dimension(25, 25));
		left.add(btnNewUnit2);

		JToolBar perspective = new JToolBar();
		perspective.setFloatable(false);
		perspective.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 1));
		add(perspective, BorderLayout.EAST);

		perspective.addSeparator(new Dimension(3, 25));
		JSplitButton btnPerspective = new JSplitButton("単体支援");
		btnPerspective.setIcon(IconSet.get("unit_perspective.gif"));
		btnPerspective.setSplit(true);
		btnPerspective.setPopupMenu(PerspectiveMenu.instance().getPopupMenu());
		btnPerspective.setPreferredSize(new Dimension(90, 25));
		perspective.add(btnPerspective);
		JSplitButton btnPerspectiveDev = new JSplitButton("開発支援");
		btnPerspectiveDev.setIcon(IconSet.get("unit_perspective.gif"));
		btnPerspectiveDev.setSplit(true);
		btnPerspectiveDev.setAlwaysDropDown(true);
		btnPerspectiveDev.setPopupMenu(PerspectiveMenu.instance().getPopupMenu());
		btnPerspectiveDev.setPreferredSize(new Dimension(90, 25));
		perspective.add(btnPerspectiveDev);
	}
}
