package org.sjitech.myassist;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import org.sjitech.myassist.core.i18n.Messages;

/**
 * startup main class
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
        g.drawString(Messages.getString("splash.waiting"), 20, 280);
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

        // startup application
        Application app = new Application();
        app.initialize();
        app.startup();
	}
}
