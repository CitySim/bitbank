package de.g18.BitBank.Extra;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Kunde;

/**
 * Klasse zum Ausdrucken der Kontostaende.
 * 
 * @author it1-markde
 * @since JRE6
 */

class PrintJob implements Printable {

	private PageFormat pageFormat;
	private Font fontForPrint;
	private String textPassage;
	private List<String> textPassages = new ArrayList<String>();
	private JWindow windowForPrint = new JWindow();
	private JTextArea textareaForPrint = new JTextArea();
	private FontMetrics fontMetrics;
	private Dimension pageDim;
	private BufferedImage bufferedImage;
	private static final int CONS = 2;
	private int linesTotal = 0;
	private int linesMaxOnPage = 0;
	private int numberOfPages = 0;
	private int pageBorders[][] = new int[999][2];

	private PrinterJob printerJob = PrinterJob.getPrinterJob();

	PrintJob(final String printText) {

		fontForPrint = new Font("Arial", Font.PLAIN, 16 * CONS);
		this.pageFormat = new PageFormat();

		pageDim = new Dimension(
				((int) this.pageFormat.getImageableWidth() - 10) * CONS,
				((int) this.pageFormat.getImageableHeight()) * CONS);

		textareaForPrint.setFont(fontForPrint);
		fontMetrics = textareaForPrint.getFontMetrics(fontForPrint);
		textareaForPrint.setLineWrap(true);
		textareaForPrint.setWrapStyleWord(true);
		textareaForPrint.setPreferredSize(pageDim);
		textareaForPrint.setTabSize(4);
		textareaForPrint.setText(printText);

		// Add on JWindow
		windowForPrint.add(textareaForPrint);
		windowForPrint.pack();

		// Wrapp text and give to TextArea
		textareaForPrint.setText(this.getWrappedText(textareaForPrint));
		pageDim = new Dimension((int) this.pageFormat.getImageableWidth()
				* CONS, (int) this.pageFormat.getImageableHeight() * CONS);
		textareaForPrint.setPreferredSize(pageDim);
		windowForPrint.pack();

		// Calculate specifications of TextArea
		linesMaxOnPage = this.getMaxLines();
		linesTotal = textareaForPrint.getLineCount();
		numberOfPages = this.getNumberOfPages();

		// Calculate Start and End of the pages and store in pageBorders
		// And split text in passages and store in textPassages
		try {
			for (int i = 0; i < numberOfPages; i++) {
				pageBorders[i][0] = textareaForPrint.getLineStartOffset(i
						* linesMaxOnPage);
			}
			for (int i = 0; i < numberOfPages - 1; i++) {
				pageBorders[i][1] = pageBorders[i + 1][0] - 1;
			}
			pageBorders[numberOfPages - 1][1] = textareaForPrint
					.getLineEndOffset(linesTotal - 1);
			for (int i = 0; i < numberOfPages; i++) {
				textPassages.add(textareaForPrint.getText(pageBorders[i][0],
						pageBorders[i][1] - pageBorders[i][0]));
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private final boolean printPage(final int page) {
		if (page < 0 | page > numberOfPages - 1) {
			return false;
		}
		printerJob.setPrintable(this, pageFormat);
		textPassage = textPassages.get(page);
		try {
			printerJob.print();
		} catch (PrinterException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private final void printAllPages() {
		printerJob.setPrintable(this, pageFormat);
		for (int i = 0; i < numberOfPages; i++) {
			printPage(i);
		}
	}

	public final int print(final Graphics g, final PageFormat pFormat,
			final int pageIndex) throws PrinterException {
		if (pageIndex > 0) {
			return Printable.NO_SUCH_PAGE;
		}

		Graphics2D g2 = (Graphics2D) g;

		g2.translate((int) pFormat.getImageableX(),
				(int) pFormat.getImageableY());
		g2.scale(1.0 / CONS, 1.0 / CONS);

		textareaForPrint.setText(textPassage);
		bufferedImage = null;
		bufferedImage = new BufferedImage(pageDim.width, pageDim.height,
				BufferedImage.TYPE_BYTE_GRAY);
		textareaForPrint.paint(bufferedImage.getGraphics());

		g2.drawImage(bufferedImage, 0, 0, textareaForPrint);
		g2.dispose();

		return Printable.PAGE_EXISTS;
	}

	// public final BufferedImage getPreviewOfPage(final int pageI) {
	// textareaForPrint.setText(textPassages.get(pageI));
	//
	// bufferedImage = null;
	// bufferedImage = new BufferedImage(pageDim.width, pageDim.height,
	// BufferedImage.TYPE_BYTE_GRAY);
	// textareaForPrint.paint(bufferedImage.getGraphics());
	//
	// try {
	// return bufferedImage;
	// } finally {
	// bufferedImage = null;
	// }
	// }

	private String getWrappedText(final JTextComponent c) {
		int len = c.getDocument().getLength();
		int offset = 0;
		StringBuffer buf = new StringBuffer((int) (len * 1.30));
		String s = "";
		try {
			while (offset < len) {
				int end = Utilities.getRowEnd(c, offset);
				if (end < 0) {
					break;
				}
				end = Math.min(end + 1, len);
				s = c.getDocument().getText(offset, end - offset);
				buf.append(s);
				if (!s.endsWith("\n")) {
					buf.append('\n');
				}
				offset = end;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		try {
			return buf.toString();
		} finally {
			buf = null;
			s = null;
		}
	}

	public final int getNumberOfPages() {
		int max = this.getMaxLines();
		int total = textareaForPrint.getLineCount();
		int pages = (int) Math.ceil((double) total / (double) max);
		return pages;
	}

	private int getMaxLines() {
		return textareaForPrint.getHeight() / fontMetrics.getHeight();
	}

	private final String generateText(final BankController controller,
			final Kunde kunde) {

		String printText = "Hello! " + "/r/n"
				+ "This is an autmatic generated mail by BitBank." + "/r/n"
				+ "/r/n";

		if (kunde.getKontenListe().size() != 0) {
			for (Konto konto : kunde.getKontenListe()) {
				printText = printText + "Konto: \"" + konto.getKontoNummer()
						+ "\" Kontostand: \"" + konto.getKontoStand() + "\""
						+ "/r/n";
			}
		} else {
			printText = printText
					+ "Sie verfügen bisher über kein Konto bei uns.";
		}

		return printText;

	}

	final void printText(final BankController controller, final Kunde kunde) {
		String printText = this.generateText(controller, kunde);
		PrintJob pt = new PrintJob(printText);
		pt.printAllPages();
	}
}