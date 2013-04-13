package de.g18.BitBank.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.Listener.KundenAnlegenListener;

/**
 * Gui Klasse zum Anlegen eines neuen Kundens.
 * 
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class KundenAnlegen extends JFrame {
	public KundenAnlegen() {

		this.setSize(450, 200);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Bank-Anwendung - Kunde anlegen");

		JPanel eingabe = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel buttons = new JPanel();
		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JLabel kundenNamenLabel = new JLabel("Kundenname");
		JTextField kundenNummerField = new JTextField(20);
		JTextField kundenNamenField = new JTextField(20);
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");
		
		Dimension labelSize = new Dimension(145, 25);
		kundenNummerLabel.setPreferredSize(labelSize);
		kundenNamenLabel.setPreferredSize(labelSize);
		eingabe.setBorder(BorderFactory.createMatteBorder(20, 25, 0, 25,
				Color.decode("#EEEEEE")));
		buttons.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20,
				Color.decode("#EEEEEE")));
		
		this.add(eingabe);
		this.add(buttons);
		eingabe.add(kundenNummerLabel);
		eingabe.add(kundenNummerField);
		eingabe.add(kundenNamenLabel);
		eingabe.add(kundenNamenField);
		buttons.add(anlegenButton);
		buttons.add(beendenButton);

		anlegenButton.addActionListener(new KundenAnlegenListener(
				kundenNummerField, kundenNamenField));
		beendenButton.addActionListener(new KundenAnlegenListener(this));

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new KundenAnlegen();
	}
}
