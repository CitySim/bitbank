package de.g18.BitBank.Gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;

/**
 * Gui Klasse zur erleichterten Kundenauswahl.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenAuswahl extends JDialog {
	private static final long serialVersionUID = -785098997227623108L;
	private Kunde kunde;

	public KundenAuswahl(final BankController controller) {
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Kundenauswahl");
		// setResizable(false);
		this.setSize(new Dimension(200, 300));
		this.setModal(true);

		final JList liste = new JList(new AbstractListModel() {
			private static final long serialVersionUID = -7562748123613036992L;

			@Override
			public int getSize() {
				return controller.getKundenCount();
			}

			@Override
			public Object getElementAt(final int index) {
				Kunde k = controller.getKundeByIndex(index);
				return k.getKundenNummmer() + " - " + k.getName();
			}
		});
		liste.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent e) {
				kunde = (controller.getKundeByIndex(liste.getSelectedIndex()));
			}
		});
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listeScrollPane = new JScrollPane(liste);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(listeScrollPane, c);

		this.setVisible(true);
	}

	public Kunde getKunde() {
		return kunde;
	}

}
