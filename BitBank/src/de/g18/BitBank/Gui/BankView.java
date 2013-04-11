package de.g18.BitBank.Gui;

import java.awt.BorderLayout;

import javax.swing.*;

import de.g18.BitBank.Gui.Listener.BankViewListener;

/**
 * Vorgegebene BankMain.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class BankView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar bankMenuBar = null;
	private JMenu Anwendungen = null;
	private JMenuItem anlegenKunde = null;
	private JMenuItem anlegenKonto = null;
	private JMenuItem durchfuehrenZahlungen = null;
	private JMenuItem durchführenUeberweisungen = null;
	private JMenuItem anzeigenKontostand = null;
	private JMenuItem ende = null;

	/**
	 * This method initializes bankMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getBankMenuBar() {
		if (bankMenuBar == null) {
			bankMenuBar = new JMenuBar();
			bankMenuBar.add(getAnwendungen());
		}
		return bankMenuBar;
	}

	/**
	 * This method initializes Anwendungen
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getAnwendungen() {
		if (Anwendungen == null) {
			Anwendungen = new JMenu();
			Anwendungen.setText("Anwendungen");
			Anwendungen.add(getAnlegenKunde());
			Anwendungen.add(getAnlegenKonto());
			Anwendungen.add(getDurchfuehrenZahlungen());
			Anwendungen.add(getDurchführenUeberweisungen());
			Anwendungen.add(getAnzeigenKontostand());
			Anwendungen.add(getEnde());
			Anwendungen.insertSeparator(5);

		}
		return Anwendungen;
	}

	/**
	 * This method initializes anlegenKunde
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getAnlegenKunde() {
		if (anlegenKunde == null) {
			anlegenKunde = new JMenuItem();
			anlegenKunde.setText("Kunde anlegen");
		}
		return anlegenKunde;
	}

	/**
	 * This method initializes anlegenKonto
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAnlegenKonto() {
		if (anlegenKonto == null) {
			anlegenKonto = new JMenuItem();
			anlegenKonto.setText("Konto anlegen");
		}
		return anlegenKonto;
	}

	/**
	 * This method initializes durchfuehrenZahlungen
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getDurchfuehrenZahlungen() {
		if (durchfuehrenZahlungen == null) {
			durchfuehrenZahlungen = new JMenuItem();
			durchfuehrenZahlungen.setText("Ein-/Auszahlungen durchführen");
		}
		return durchfuehrenZahlungen;
	}

	/**
	 * This method initializes durchführenUeberweisungen
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getDurchführenUeberweisungen() {
		if (durchführenUeberweisungen == null) {
			durchführenUeberweisungen = new JMenuItem();
			durchführenUeberweisungen.setText("Überweisungen durchführen");
		}
		return durchführenUeberweisungen;
	}

	/**
	 * This method initializes anzeigenKontostand
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAnzeigenKontostand() {
		if (anzeigenKontostand == null) {
			anzeigenKontostand = new JMenuItem();
			anzeigenKontostand.setText("Kontostandsübersicht anzeigen");
		}
		return anzeigenKontostand;
	}

	/**
	 * This method initializes ende
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getEnde() {
		if (ende == null) {
			ende = new JMenuItem();
			ende.setText("Beenden");
		}
		return ende;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BankView thisClass = new BankView();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);

			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public BankView() {
		super();
		initialize();
		new BankViewListener(Anwendungen);

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(587, 456);
		this.setJMenuBar(getBankMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Bank-Anwendung");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

} // @jve:decl-index=0:visual-constraint="18,15"