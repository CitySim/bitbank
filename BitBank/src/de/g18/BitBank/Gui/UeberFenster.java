package de.g18.BitBank.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 14.04.13 Time: 14:51 To change
 * this template use File | Settings | File Templates.
 */
public class UeberFenster extends JDialog {
	private static final long serialVersionUID = -2001045174878425586L;

	public UeberFenster() {
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Über BitBank");
		setResizable(false);
		setModal(true);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel iconLabel = new JLabel(new ImageIcon(myPicture));

		c.gridx = 0;
		c.gridy = 0;
		add(iconLabel);

		JLabel textLabel = new JLabel();
		textLabel.setText("<html><h3>BitBank</h3>erstellt von:<ul><li>Björn Korella</li><li>Sven Tatter</li><li>Dennis Markmann</li></ul>Logo: http://commons.wikimedia.org/wiki/File:Bitcoin_logo.svg</html>");
		textLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10, 10, 10));

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		add(textLabel);

		pack();
		setVisible(true);
	}
}
