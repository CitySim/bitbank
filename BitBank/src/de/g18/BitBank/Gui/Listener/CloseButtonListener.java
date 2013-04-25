package de.g18.BitBank.Gui.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener für die Closebuttons des Tabmenues.
 * 
 * @author it1-markde
 * @since JRE6
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
