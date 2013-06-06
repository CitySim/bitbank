package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Listener für die Closebuttons des Tabmenues.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

class CloseButtonListener implements ActionListener {

    private final JTabbedPane tabsPane;
    private final JPanel panel;

    CloseButtonListener(final JTabbedPane tabsPane, final JPanel panel) {
        this.tabsPane = tabsPane;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        this.tabsPane.remove(this.panel);
    }
}
