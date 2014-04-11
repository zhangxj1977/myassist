package org.sjitech.myassist.view.views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import org.jdesktop.swingx.JXPanel;
import org.sjitech.myassist.view.images.IconSet;
import org.sjitech.myassist.view.menus.PerspectiveMenu;
import org.sjitech.myassist.view.swing.JSplitButton;

@SuppressWarnings("serial")
public class PanelScanTestClass extends JXPanel {

	public PanelScanTestClass() {
		setLayout(new FlowLayout());
		JSplitButton btnTest = new JSplitButton("テスト", IconSet.get("class_obj.gif"));
		btnTest.setSplit(true);
		btnTest.setPopupMenu(PerspectiveMenu.instance().getPopupMenu());
		btnTest.setPreferredSize(new Dimension(80, 25));
		add(btnTest);
	}
}
