package org.sjitech.myassist.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jdesktop.swingx.JXFrame;
import org.sjitech.myassist.Application;
import org.sjitech.myassist.core.i18n.Messages;
import org.sjitech.myassist.view.images.IconSet;

/**
 * main frame
 * 
 * @author sji_zhang_x
 *
 */
@SuppressWarnings("serial")
public class FrameMain extends JXFrame {

	/** main application */
	Application application;
	
	/**
	 * @param application
	 */
	public FrameMain(Application application) {
		super();
		this.application = application;
		setTitle(Messages.getString("window.title"));
		setPreferredSize(new Dimension(1024, 768));
		setSize(1024, 768);
		setIconImage(((ImageIcon) IconSet.get("application.gif")).getImage());
		
		initWindowListener();
	}

	/**
	 * windows event
	 */
	private void initWindowListener() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				application.shutdown();
			}
		});
	}
}
