package org.sjitech.myassist;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;

import org.jdesktop.swingx.JXFrame.StartPosition;
import org.sjitech.myassist.view.FrameMain;
import org.sjitech.myassist.view.TopToolBar;
import org.sjitech.myassist.view.docks.Minimizer;
import org.sjitech.myassist.view.images.IconSet;
import org.sjitech.myassist.view.menus.FileMenu;
import org.sjitech.myassist.view.menus.WindowMenu;
import org.sjitech.myassist.view.views.PanelExecuteMethods;
import org.sjitech.myassist.view.views.PanelInspectMethods;
import org.sjitech.myassist.view.views.PanelScanTestClass;

import bibliothek.extension.gui.dock.theme.EclipseTheme;
import bibliothek.gui.DockController;
import bibliothek.gui.DockFrontend;
import bibliothek.gui.dock.DefaultDockable;
import bibliothek.gui.dock.FlapDockStation;
import bibliothek.gui.dock.ScreenDockStation;
import bibliothek.gui.dock.SplitDockStation;
import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.station.split.SplitDockGrid;
import bibliothek.gui.dock.station.split.SplitDockProperty;
import bibliothek.gui.dock.support.lookandfeel.LookAndFeelList;


/**
 * Application class
 * 
 * @author sji_zhang_x
 *
 */
public class Application {

	/** top frame */
	FrameMain frame = null;

	/** when frame is closing, there need to destroy */
	private List<Runnable> runOnClose = new ArrayList<Runnable>();

	/** main access to the docking framework */
	private DockFrontend frontend;

	/** dockable screen */
	private ScreenDockStation screen;

	/** central docking station */
	private SplitDockStation station;

	/**
	 * 
	 */
	public Application() {
	}
	
	/**
	 * before startup. init resources
	 */
	public void initialize() {
		initLayout();
	}
	
	/**
	 * startup application
	 */
	public void startup() {
		screen.setShowing(true);

		frame.setStartPosition(StartPosition.CenterInScreen);
		frame.setVisible(true);
	}

	/**
	 * quit application
	 */
	public void shutdown() {
		frame.dispose();
		screen.setShowing(false);
		for (Runnable onClose : runOnClose) {
			onClose.run();
		}
		System.exit(0);
	}

	/**
	 * layout init
	 */
	@SuppressWarnings("deprecation")
	private void initLayout() {
		// disable show core warning message
        DockController.disableCoreWarning();
		// system look and feel set
		LookAndFeelList list = LookAndFeelList.getDefaultList();
		list.setLookAndFeel(list.getSystem());

		frame = new FrameMain(this);
		frontend = new DockFrontend(frame);
        screen = new ScreenDockStation(frame);
        station = new SplitDockStation();

		frontend.setDefaultHideable(true);
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		Container center = new Container();
		center.setBackground(SystemColor.control);
		content.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout());
		center.add(station, BorderLayout.CENTER);

		FlapDockStation north = new FlapDockStation();
		FlapDockStation south = new FlapDockStation();
		FlapDockStation east = new FlapDockStation();
		FlapDockStation west = new FlapDockStation();
		center.add(south.getComponent(), BorderLayout.SOUTH);
		center.add(north.getComponent(), BorderLayout.NORTH);
		center.add(east.getComponent(), BorderLayout.EAST);
		center.add(west.getComponent(), BorderLayout.WEST);

		Minimizer minimizer = new Minimizer(frontend.getController());
		minimizer.addAreaNormalized(station);
		minimizer.addAreaNormalized(screen);
		minimizer.setDefaultStation(station);
		minimizer.addAreaMinimized(south, SplitDockProperty.SOUTH);
		minimizer.addAreaMinimized(east, SplitDockProperty.EAST);
		minimizer.addAreaMinimized(west, SplitDockProperty.WEST);

		this.destroyOnClose(frontend);

		frontend.addRoot("north", north);
		frontend.addRoot("south", south);
		frontend.addRoot("east", east);
		frontend.addRoot("west", west);
		frontend.addRoot("root", station);
		frontend.addRoot("screen", screen);

		frontend.getController().setTheme(new EclipseTheme());

		buildDefaultPerspective();
		buildMenu();
		buildToolBar();

	}

	/**
	 * 
	 */
	private void buildDefaultPerspective() {
		// Setup dockables
		DefaultDockable scanTestClass = new DefaultDockable(
				new PanelScanTestClass(),
				"classes",
				IconSet.get("classes.gif"));
		DefaultDockable scanTestMethod = new DefaultDockable(
				new PanelInspectMethods(),
				"methods",
				IconSet.get("meth_obj.gif"));
		DefaultDockable runTestMethod = new DefaultDockable(
				new PanelExecuteMethods(),
				"execute",
				IconSet.get("run_method.gif"));

		frontend.addDockable("classes", scanTestClass);
		frontend.addDockable("methods", scanTestMethod);
		frontend.addDockable("run", runTestMethod);

		SplitDockGrid grid = new SplitDockGrid();
		grid.addDockable(0, 0, 2, 1, scanTestClass);
		grid.addDockable(1, 0, 3, 1, scanTestMethod);
		grid.addDockable(0, 2, 4, 1, runTestMethod);
		station.dropTree(grid.toTree());
	}

	/**
	 * Builds the menubar and adds it to {@link #frame}
	 */
	private void buildMenu() {
		JMenuBar menubar = new JMenuBar();
		menubar.setBorderPainted(false);

		FileMenu fileMenu = new FileMenu(this);
		menubar.add(fileMenu);

		WindowMenu windowMenu = new WindowMenu(frontend);
		menubar.add(windowMenu);

		frame.setJMenuBar(menubar);
	}

	/**
	 * Builds the toolbar and adds it to top
	 */
	private void buildToolBar() {
		TopToolBar toolbar = new TopToolBar();
		
		frame.setToolBar(toolbar);
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
