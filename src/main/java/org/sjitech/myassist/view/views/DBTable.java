package org.sjitech.myassist.view.views;

import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXTable;

/**
 * database table data editor
 * 
 * @author sji_zhang_x
 *
 */
public class DBTable extends JXTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4004110475616737804L;

	public DBTable() {
		super();
	}

	public DBTable(TableModel dm) {
		super(dm);
	}

	public DBTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public DBTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public DBTable(Vector<?> rowData, Vector<?> columnNames) {
		super(rowData, columnNames);
	}

	public DBTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	public DBTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
	}

}
