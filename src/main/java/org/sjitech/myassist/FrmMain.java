package org.sjitech.myassist;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jdesktop.swingx.JXFrame;
import org.sjitech.myassist.dbview.PanelConnection;

import bibliothek.gui.DockController;
import bibliothek.gui.DockFrontend;
import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.common.DefaultSingleCDockable;
import bibliothek.gui.dock.common.SingleCDockable;

/**
 * gui main frame
 *
 * @author zhangxj
 *
 */
/**
 * @author zhangxj
 *
 */
@SuppressWarnings("serial")
public class FrmMain extends JXFrame {

	/**
	 * when frame is closing, there need to destroy
	 */
	private List<Runnable> runOnClose = new ArrayList<Runnable>();

	/**
	 * @param title
	 */
	public FrmMain(String title) {
		super(title);
		initPerspective();
		initWindowListener();
	}

	/**
	 * layout init
	 */
	private void initPerspective() {
		// Setup controller
		CControl control = new CControl(this);
		this.destroyOnClose(control);
		// Setup stations
		this.add(control.getContentArea(), BorderLayout.CENTER);
		// Setup dockables
		SingleCDockable dbview = new DefaultSingleCDockable("DBVIEW_CONN", "データベース接続", new PanelConnection());
		control.addDockable(dbview);
		dbview.setVisible(true);

		//
	}

	/**
	 * windows event
	 */
	private void initWindowListener() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}

			public void windowClosed(WindowEvent e) {
				for (Runnable onClose : runOnClose) {
					onClose.run();
				}
			}
		});
	}

	/**
	 * @param run
	 */
	public void runOnClose(Runnable run) {
		runOnClose.add(run);
	}

	/**
	 * @param control
	 */
	public void destroyOnClose(final CControl control) {
		runOnClose(new Runnable() {
			public void run() {
				control.destroy();
			}
		});
	}

	/**
	 * @param controller
	 */
	public void destroyOnClose(final DockController controller) {
		runOnClose(new Runnable() {
			public void run() {
				controller.kill();
			}
		});
	}

	/**
	 * @param frontend
	 */
	public void destroyOnClose(final DockFrontend frontend) {
		runOnClose(new Runnable() {
			public void run() {
				frontend.kill();
			}
		});
	}
}
