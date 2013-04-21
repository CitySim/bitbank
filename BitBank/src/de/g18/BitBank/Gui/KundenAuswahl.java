package de.g18.BitBank.Gui;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 21.04.13
 * Time: 12:03
 * To change this template use File | Settings | File Templates.
 */
public class KundenAuswahl extends JDialog {

	public KundenAuswahl(final BankController controller) {
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Kundenauswahl");
		//setResizable(false);
		setSize(new Dimension(100, 200));
		setModal(true);

		JList liste = new JList(new AbstractListModel() {
			@Override
			public int getSize() {
				return controller.getKundenCount();
			}

			@Override
			public Object getElementAt(int index) {
				Kunde k = controller.getKundeByIndex(index);
				return k.getKundenNummmer() + " - " + k.getName();
			}
		});
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listeScrollPane = new JScrollPane(liste);

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		add(listeScrollPane, c);

		setVisible(true);
	}
}
