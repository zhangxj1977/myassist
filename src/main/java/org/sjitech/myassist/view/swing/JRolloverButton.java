package org.sjitech.myassist.view.swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * compsite split and rollover button
 *
 * @author zhangxj
 *
 */
public class JRolloverButton extends JButton implements ActionListener, MouseListener {

	/** is a split button */
	private boolean isSplit = false;
	/** */
	private int separatorSpacing = 4;
	private int splitWidth = 22;
	private int arrowSize = 8;
	private boolean onSplit;
	private Rectangle splitRectangle;
	private JPopupMenu popupMenu;
	private boolean alwaysDropDown;
	private Color arrowColor = Color.BLACK;
	private Color disabledArrowColor = Color.GRAY;

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
	}

	/**
	 * @param text
	 */
	public JRolloverButton(String text) {
		this(text, null);
	}

	/**
	 * @return isSplit
	 */
	public boolean isSplit() {
		return isSplit;
	}

	/**
	 * @param isSplit
	 */
	public void setSplit(boolean isSplit) {
		this.isSplit = isSplit;
	}

	/**
	 * Returns the JPopupMenu if set, null otherwise.
	 *
	 * @return JPopupMenu
	 */
	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	/**
	 * Sets the JPopupMenu to be displayed, when the split part of the button is
	 * clicked.
	 *
	 * @param popupMenu
	 */
	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

    /**
     * Returns the separatorSpacing.
     * Separator spacing is the space above and below the separator
     * ( the line drawn when you hover your mouse
     * over the split part of the button).
     * @return separatorSpacing
     */
    public int getSeparatorSpacing() {
        return separatorSpacing;
    }

    /**
     * Sets the separatorSpacing.
     * Separator spacing is the space above and below the separator
     * ( the line drawn when you hover your mouse
     * over the split part of the button).
     * @param separatorSpacing
     */
    public void setSeparatorSpacing(int separatorSpacing) {
        this.separatorSpacing = separatorSpacing;
    }

    /**
     * Show the dropdown menu, if attached, even if the button part is clicked.
     * @return true if alwaysDropdown, false otherwise.
     */
    public boolean isAlwaysDropDown() {
        return alwaysDropDown;
    }

    /**
     * Show the dropdown menu, if attached, even if the button part is clicked.
     * @param alwaysDropDown true to show the attached dropdown
     * even if the button part is clicked, false otherwise
     */
    public void setAlwaysDropDown(boolean alwaysDropDown) {
        this.alwaysDropDown = alwaysDropDown;
    }

    /**
     * Gets the color of the arrow.
     * @return arrowColor
     */
    public Color getArrowColor() {
        return arrowColor;
    }

    /**
     * Set the arrow color.
     * @param arrowColor
     */
    public void setArrowColor(Color arrowColor) {
        this.arrowColor = arrowColor;
    }

    /**
     *  gets the disabled arrow color
     * @return disabledArrowColor color of the arrow if no popup attached.
     */
    public Color getDisabledArrowColor() {
        return disabledArrowColor;
    }

    /**
     * sets the disabled arrow color
     * @param disabledArrowColor color of the arrow if no popup attached.
     */
    public void setDisabledArrowColor(Color disabledArrowColor) {
        this.disabledArrowColor = disabledArrowColor;
    }

    /**
     * Splitwidth is the  width of the split part of the button.
     * @return splitWidth
     */
    public int getSplitWidth() {
        return splitWidth;
    }

    /**
     * Splitwidth is the  width of the split part of the button.
     * @param splitWidth
     */
    public void setSplitWidth(int splitWidth) {
        this.splitWidth = splitWidth;
    }

    /**
     * gets the size of the arrow.
     * @return size of the arrow
     */
    public int getArrowSize() {
        return arrowSize;
    }

    /**
     * sets the size of the arrow
     * @param arrowSize
     */
    public void setArrowSize(int arrowSize) {
        this.arrowSize = arrowSize;
    }

	/* (非 Javadoc)
	 * @see javax.swing.JButton#updateUI()
	 */
	public void updateUI() {
		super.updateUI();
		setBorder(null);
	}

	/**
	 * Gets the image to be drawn in the split part. If no is set, a new image
	 * is created with the triangle.
	 *
	 * @return image
	 */
	public Image getImage() {
		Graphics2D g = null;
		BufferedImage img = new BufferedImage(arrowSize, arrowSize,
				BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) img.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.setColor(popupMenu != null ? arrowColor : disabledArrowColor);
		// this creates a triangle facing right >
		g.fillPolygon(new int[] { 0, 0, arrowSize / 2 }, new int[] { 0,
				arrowSize, arrowSize / 2 }, 3);
		g.dispose();
		// rotate it to face downwards
		img = rotate(img, 90);
		BufferedImage dimg = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) dimg.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(img, null, 0, 0);
		g.dispose();
		for (int i = 0; i < dimg.getHeight(); i++) {
			for (int j = 0; j < dimg.getWidth(); j++) {
				if (dimg.getRGB(j, i) == Color.WHITE.getRGB()) {
					dimg.setRGB(j, i, 0x8F1C1C);
				}
			}
		}

		Image image = Toolkit.getDefaultToolkit().createImage(dimg.getSource());
		return image;
	}

	/**
	 *
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!isSplit) {
			return;
		}

		Graphics gClone = g.create();
		Color oldColor = gClone.getColor();
		splitRectangle = new Rectangle(getWidth() - splitWidth, 0, splitWidth,
				getHeight());
		gClone.translate(splitRectangle.x, splitRectangle.y);
		int mh = getHeight() / 2;
		int mw = splitWidth / 2;
		gClone.drawImage(getImage(), mw - arrowSize / 2,
				mh + 2 - arrowSize / 2, null);
		if (onSplit && !alwaysDropDown && popupMenu != null) {
			gClone.setColor(UIManager.getLookAndFeelDefaults().getColor(
					"Button.background"));
			gClone.drawLine(1, separatorSpacing + 2, 1, getHeight()
					- separatorSpacing - 2);
			gClone.setColor(UIManager.getLookAndFeelDefaults().getColor(
					"Button.shadow"));
			gClone.drawLine(2, separatorSpacing + 2, 2, getHeight()
					- separatorSpacing - 2);
		}
		gClone.setColor(oldColor);
	}

	/**
	 * Rotates the given image with the specified angle.
	 *
	 * @param img
	 *            image to rotate
	 * @param angle
	 *            angle of rotation
	 * @return rotated image
	 */
	private BufferedImage rotate(BufferedImage img, int angle) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg = new BufferedImage(w, h, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.rotate(Math.toRadians(angle), w / 2, h / 2);
		g.drawImage(img, null, 0, 0);
		return dimg;
	}

	/**
	 * @param e
	 */
	public void mouseEntered(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.isEnabled()) {
			button.setBorder(rollBorder);
		}
	}

	/**
	 * @param e
	 */
	public void mousePressed(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.isEnabled()) {
			button.setBorder(pressedBorder);
		}
	}

	/**
	 * @param e
	 */
	public void mouseReleased(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.isEnabled()) {
			button.setBorder(rollBorder);
		}
	}

    /**
     *
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
		if (!isSplit) {
			return;
		}
        if (splitRectangle.contains(e.getPoint())) {
            onSplit = true;
        } else {
            onSplit = false;
        }
        repaint(splitRectangle);
    }

	/**
	 *
	 * @param e
	 */
	public void mouseExited(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		button.setBorder(emptyBorder);
		if (!isSplit) {
			return;
		}
		onSplit = false;
		repaint(splitRectangle);
	}

	/* (非 Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 *
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (popupMenu == null) {
		} else if (alwaysDropDown) {
			popupMenu.show(this, getWidth()
					- (int) popupMenu.getPreferredSize().getWidth(),
					getHeight());
		} else if (onSplit) {
			popupMenu.show(this, getWidth()
					- (int) popupMenu.getPreferredSize().getWidth(),
					getHeight());
		} else {
		}
	}

}
