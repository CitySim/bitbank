package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

/**
 * Listener für die Closebuttons des Tabmenues.
 * 
 * @author it1-markde
 * @since JRE6
 */

class CloseButtonListener implements ActionListener {

	private JTabbedPane tabsPane;
	private String tabName;

	CloseButtonListener(final JTabbedPane tabsPane, final String tabName) {

		this.tabsPane = tabsPane;
		this.tabName = tabName;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {

		this.tabsPane.remove(tabsPane.indexOfTab(this.tabName));

	}
}
