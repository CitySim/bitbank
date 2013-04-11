package de.g18.BitBank.Gui.Listener;

import java.awt.Component;

import javax.swing.JMenu;

public class BankViewListener {

	public BankViewListener(JMenu anwendungen) {

		for (Component component : anwendungen.getMenuComponents()) {
			System.out.println(component);
		}
		// System.out.println(anwendungen.getMenuComponents());

	}
}
