package org.sjitech.myassist.view.views;

import java.awt.BorderLayout;

import org.sjitech.myassist.view.images.IconSet;

import bibliothek.gui.dock.DefaultDockable;

/**
 * test classes suite view
 * 
 * @author sji_zhang_x
 *
 */
public class UnitSuiteView extends DefaultDockable {

	/**
	 * 
	 */
	public UnitSuiteView() {
		setTitleText("クラスブラウザー");
		setTitleIcon(IconSet.get("class_hi.gif"));
		setLayout(new BorderLayout());
	}
}
