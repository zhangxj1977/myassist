package org.sjitech.myassist.view.views;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.TreeTableModel;

/**
 * java bean editor ui base
 * 
 * @author sji_zhang_x
 *
 */
public class BeanTable extends JXTreeTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1033852855594537663L;

	/**
	 * 
	 */
	public BeanTable() {
	}

	/**
	 * @param treeModel
	 */
	public BeanTable(TreeTableModel treeModel) {
		super(treeModel);
	}

}
