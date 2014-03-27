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
    static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"foo", "bar", "baz"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
    }

	public static void main(String[] args) {

		System.setSecurityManager(null);

		final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
		Graphics2D g = splash.createGraphics();
		if (g == null) {
			System.out.println("g is null");
			return;
		}
		for (int i = 0; i < 100; i++) {
			renderSplashFrame(g, i);
			splash.update();
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
			}
		}
        splash.close();

		FrmMain frmMain = new FrmMain("myassist", true);
		frmMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMain.setVisible(true);
	}

}
