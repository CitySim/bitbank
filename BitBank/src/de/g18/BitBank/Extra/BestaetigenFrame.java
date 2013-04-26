package de.g18.BitBank.Extra;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;

/**
 * Frame zur Bestaetigung von Druck und E-Mail Vorgaengen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class BestaetigenFrame extends JFrame {
	private static final long serialVersionUID = 4251619441226397716L;

	public BestaetigenFrame(final BankController controller,
			final String operation) {

		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextField emailField = null;
		if (operation.equals("email")) {
			this.setSize(new Dimension(300, 140));
			this.setTitle("E-Mail");
			JLabel emailLabel = new JLabel("E-Mail Adresse");
			emailField = new JTextField();

			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 3;
			c.fill = GridBagConstraints.BOTH;
			add(emailLabel, c);

			c.gridx = 3;
			c.gridy = 0;
			c.weightx = 3;
			c.fill = GridBagConstraints.BOTH;
			add(emailField, c);
		}
		if (operation.equals("drucken")) {
			this.setSize(new Dimension(280, 100));
			this.setTitle("Drucken");
		}

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField();
		JButton bestaetigenButton = new JButton("Bestätigen");
		JButton abbrechenButton = new JButton("Abbrechen");

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 3;
		c.fill = GridBagConstraints.BOTH;
		add(kundenNummerLabel, c);

		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 3;
		c.fill = GridBagConstraints.BOTH;
		add(kundenNummerField, c);

		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 3;
		c.fill = GridBagConstraints.BOTH;
		add(bestaetigenButton, c);

		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 3;
		c.fill = GridBagConstraints.BOTH;
		add(abbrechenButton, c);

		this.setVisible(true);

		BestaetigenFrameListener listener = new BestaetigenFrameListener(
				controller, operation, this, kundenNummerField, emailField);

		bestaetigenButton.addActionListener(listener);
		abbrechenButton.addActionListener(listener);

	}
}
