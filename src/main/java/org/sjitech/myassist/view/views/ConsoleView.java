package org.sjitech.myassist.view.views;

import java.awt.BorderLayout;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.sjitech.myassist.view.images.IconSet;

import bibliothek.gui.dock.DefaultDockable;

/**
 * output console view
 * 
 * @author sji_zhang_x
 *
 */
public class ConsoleView extends DefaultDockable {

	/**
	 * 
	 */
	private RSyntaxTextArea textArea;
	/**
	 * 
	 */
	private RTextScrollPane scpPane;
	
	/**
	 * 
	 */
	public ConsoleView() {
		setTitleText("コンソール");
		setTitleIcon(IconSet.get("console_view.gif"));

		textArea = new RSyntaxTextArea();
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		setLayout(new BorderLayout());
		scpPane = new RTextScrollPane(textArea, false);
		add(scpPane, BorderLayout.CENTER);
	}

	/**
	 * show the line numbers or not
	 * @param b
	 */
	public void setShowLineNumbers(boolean b) {
		scpPane.setLineNumbersEnabled(b);
	}

	/**
	 * append text to console
	 * 
	 * @param str
	 */
	public void output(String str) {
		textArea.append(str);
	}

	/**
	 * clear the console
	 */
	public void clear() {
		textArea.setText("");
	}
}
