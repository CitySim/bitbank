package de.g18.BitBank.Gui.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener für die Closebuttons des Tabmenues.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class CloseButtonListener implements ActionListener {

	private JTabbedPane tabsPane;
	private JPanel panel;

	public CloseButtonListener(final JTabbedPane tabsPane, final JPanel panel) {
		this.tabsPane = tabsPane;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.tabsPane.remove(panel);
	}
}
