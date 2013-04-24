package de.g18.BitBank;

public class NumberParser {

	public double parseDouble(String text) throws NumberFormatException {

		if (text.contains(",")) {
			text = (text.substring(0, text.indexOf(",")) + "." + (text
					.substring(text.indexOf(",") + 1)));
		}

		double betrag = Double.parseDouble(text);

		return betrag;
	}

}
