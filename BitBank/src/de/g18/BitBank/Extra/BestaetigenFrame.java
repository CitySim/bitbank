package de.g18.BitBank.Extra;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import de.g18.BitBank.BankController;

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
		setResizable(false);
		JTextArea emailArea = null;
		if (operation.equals("email")) {
			this.setSize(new Dimension(300, 140));
			this.setTitle("E-Mail");
			JLabel emailLabel = new JLabel("E-Mail Adresse");
			emailArea = new JTextArea();

			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 3;
			c.fill = GridBagConstraints.BOTH;
			add(emailLabel, c);

			c.gridx = 3;
			c.gridy = 0;
			c.weightx = 3;
			c.fill = GridBagConstraints.BOTH;
			add(emailArea, c);
		}
		if (operation.equals("drucken")) {
			this.setSize(new Dimension(250, 100));
			this.setTitle("Drucken");
		}

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextArea kundenNummerArea = new JTextArea();
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
		add(kundenNummerArea, c);

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
				controller, operation, this, bestaetigenButton,
				abbrechenButton, kundenNummerArea, emailArea);

		bestaetigenButton.addActionListener(listener);
		abbrechenButton.addActionListener(listener);

	}
}