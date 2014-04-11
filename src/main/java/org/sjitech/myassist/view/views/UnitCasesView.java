package org.sjitech.myassist.view.views;

import java.awt.BorderLayout;

import org.sjitech.myassist.view.images.IconSet;

import bibliothek.gui.dock.DefaultDockable;

/**
 * @author sji_zhang_x
 *
 */
public class UnitCasesView extends DefaultDockable {

	/**
	 * 
	 */
	public UnitCasesView(String methodName) {
		if (methodName == null || methodName.equals("")) {
			setTitleText("メソッド(未知)");
		} else {
			setTitleText(methodName);
		}
		setTitleIcon(IconSet.get("meth_obj.gif"));
		setLayout(new BorderLayout());
	}
}
