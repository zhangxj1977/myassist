package org.sjitech.myassist;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.JFrame;

/**
 * application startup main class
 *
 * @author sji_zhang_x
 *
 */
public class Main {

    /**
     * @param g
     * @param frame
     */
    private static void renderSplashFrame(Graphics2D g) {
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(20, 280, 200, 40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("しばらくお待ちください．．．", 20, 280);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setSecurityManager(null);

		// show splash screen
		final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash != null) {
			Graphics2D g = splash.createGraphics();
			if (g != null) {
				renderSplashFrame(g);
				splash.update();
			}
        }

        // do initialize

        // show main frame
		FrmMain frmMain = new FrmMain("myassist", true);
		frmMain.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// close splash screen before frame show
        if (splash != null) {
        	splash.close();
        }

		frmMain.setVisible(true);
	}

}
