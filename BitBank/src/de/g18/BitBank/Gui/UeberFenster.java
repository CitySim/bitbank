package de.g18.BitBank.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Gui Klasse fuer das ueberMenu.
 *
 * @author it1-korebj
 * @since JRE6
 */

public class UeberFenster extends JDialog {
	private static final long serialVersionUID = -2001045174878425586L;

	public UeberFenster() {
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Über BitBank");
		this.setResizable(false);
		this.setModal(true);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(getClass().getClassLoader()
					.getResourceAsStream("de/g18/BitBank/Gui/Images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel iconLabel = new JLabel(new ImageIcon(myPicture));
		iconLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10,
				10, 10));

		c.gridx = 0;
		c.gridy = 0;
		this.add(iconLabel);

		JLabel textLabel = new JLabel();
		textLabel
				.setText("<html><h3>BitBank</h3>erstellt von:<ul><li>Björn Korella</li><li>Sven Tatter</li><li>Dennis Markmann</li></ul>Logo: http://commons.wikimedia.org/wiki/File:Bitcoin_logo.svg</html>");
		textLabel.setBorder(new BorderUIResource.EmptyBorderUIResource(10, 10,
				10, 10));

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		this.add(textLabel);

		this.pack();
		this.setVisible(true);
	}
}
