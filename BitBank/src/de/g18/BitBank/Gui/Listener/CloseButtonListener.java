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

public class CloseButtonListener implements ActionListener {

	private JTabbedPane tabsPane;
	private String tabName;

	public CloseButtonListener(JTabbedPane tabsPane, String tabName) {

		this.tabsPane = tabsPane;
		this.tabName = tabName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.tabsPane.remove(tabsPane.indexOfTab(this.tabName));

	}
}
