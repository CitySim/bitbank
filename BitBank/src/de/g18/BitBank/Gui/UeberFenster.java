package de.g18.BitBank.Gui;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 14.04.13 Time: 14:51 To change
 * this template use File | Settings | File Templates.
 */
public class UeberFenster extends JDialog {
	private static final long serialVersionUID = -2001045174878425586L;

	public UeberFenster() {
		setSize(250, 150);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Über BitBank");
		setResizable(false);
		setModal(true);

		JLabel textLabel = new JLabel();
		textLabel
				.setText("<html><h3>BitBank</h3>erstellt von:<ul><li>Björn Korella</li><li>Sven Tatter</li><li>Dennis</li></ul></html>");
		textLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10,
				10, 10));

		add(textLabel);

		setVisible(true);
	}
}
