package org.sjitech.myassist.view.swing;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * rollover button
 *
 * @author zhangxj
 *
 */
@SuppressWarnings("serial")
public class JRolloverButton extends JButton implements MouseListener {

	/** for rollover */
	Border rollBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED,
			Color.white, SystemColor.control, SystemColor.control, new Color(
					103, 101, 98));
	Border pressedBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
			Color.white, SystemColor.control, SystemColor.control, new Color(
					103, 101, 98));
	EmptyBorder emptyBorder = new EmptyBorder(2, 2, 2, 2);

	/**
	 *
	 */
	public JRolloverButton() {
		this(null, null);
	}

	/**
	 * @param icon
	 */
	public JRolloverButton(Icon icon) {
		this(null, icon);
	}

	/**
	 * @param text
	 * @param icon
	 */
	public JRolloverButton(String text, Icon icon) {
		super(text, icon);
		setBorder(emptyBorder);
		addMouseListener(this);
	}

	/**
	 * @param text
	 */
	public JRolloverButton(String text) {
		this(text, null);
	}

	/* (非 Javadoc)
	 * @see javax.swing.JButton#updateUI()
	 */
	public void updateUI() {
		super.updateUI();
		setBorder(emptyBorder);
		setFocusPainted(false);
		setContentAreaFilled(false);
	}

	/**
	 * @param e
	 */
	public void mouseEntered(MouseEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();
		if (button.isEnabled()) {
			button.setBorder(rollBorder);
		}
	}

	/**
	 * @param e
	 */
	public void mousePressed(MouseEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();
		if (button.isEnabled()
				&& e.getButton() == MouseEvent.BUTTON1) {
			button.setBorder(pressedBorder);
		}
	}

	/**
	 * @param e
	 */
	public void mouseReleased(MouseEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();
		if (button.isEnabled()) {
			button.setBorder(rollBorder);
		}
	}

	/* (非 Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();
		button.setBorder(emptyBorder);
	}

}
