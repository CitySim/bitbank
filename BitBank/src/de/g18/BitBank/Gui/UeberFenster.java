package de.g18.BitBank.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.BorderUIResource;

import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.IconHelper;

/**
 * Gui Klasse fuer das ueberMenu.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class UeberFenster extends JDialog {

    private static final long serialVersionUID = -2001045174878425586L;

    public UeberFenster() {
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Über BitBank");
        this.setResizable(false);
        this.setModal(true);

        final JLabel iconLabel = new JLabel(new IconHelper().getIcon("de/g18/BitBank/Gui/Images/icon.png"));
        iconLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10, 10, 10));

        c.gridx = 0;
        c.gridy = 0;
        this.add(iconLabel);

        final JLabel textLabel = new JLabel();
        textLabel.setText("<html><h3>BitBank</h3>erstellt von:<ul><li>Björn Korella</li><li>Sven Tatter</li><li>Dennis Markmann</li></ul>Logo: http://commons.wikimedia.org/wiki/File:Bitcoin_logo.svg</html>");
        textLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10, 10, 10));

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(textLabel);

        this.pack();
        this.setVisible(true);
    }
}
