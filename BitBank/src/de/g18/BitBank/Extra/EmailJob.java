package de.g18.BitBank.Extra;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Kunde;

/**
 * Klasse zum Versenden einer E-Mail mit den Kontostaenden.
 * 
 * @author it1-markde
 * @since JRE6
 */

class EmailJob {

	final void initializeEmailSending(final BankController controller,
			final Kunde kunde, final String email)
			throws EmailAdresseUngueltigException, MessagingException {

		String username = "bitbank@gmx.de";
		String password = "bitbank12";
		String senderAddress = "bitbank@gmx.de";
		String subject = "BitBank";
		String smtpHost = "smtp.gmx.net";

		this.sendMail(smtpHost, username, password, senderAddress, subject,
				controller, kunde, email);
	}

	private final void sendMail(final String smtpHost, final String username,
			final String password, final String senderAddress,
			final String subject, final BankController controller,
			final Kunde kunde, final String emailAdress)
			throws EmailAdresseUngueltigException, MessagingException {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.setProperty("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		MailAuthenticator auth = new MailAuthenticator(username, password);
		Session session = Session.getDefaultInstance(properties, auth);

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(senderAddress));

		msg.setSubject(subject);
		msg.setHeader("GroupBuilder", "GroupBuilder");
		msg.setSentDate(new Date());
		MimeMultipart mailContent;

		mailContent = this.generateMailContent(controller, kunde);

		msg.setContent(mailContent);

		if (emailAdress != null && !emailAdress.equals("")) {
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailAdress, false));
			try {
				Transport.send(msg);
			} catch (javax.mail.SendFailedException e) {
				throw new EmailAdresseUngueltigException(emailAdress);
			}
		}

	}

	private class MailAuthenticator extends Authenticator {
		private final String user;
		private final String password;

		public MailAuthenticator(final String user, final String password) {
			this.user = user;
			this.password = password;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.user, this.password);
		}
	}

	private MimeMultipart generateMailContent(final BankController controller,
			final Kunde kunde) throws MessagingException {

		String emailText = "Hello! " + System.lineSeparator()
				+ "This is an autmatic generated mail by BitBank."
				+ System.lineSeparator() + System.lineSeparator();

		for (Konto konto : kunde.getKontenListe()) {
			emailText = emailText + "Konto: \"" + konto.getKontoNummer()
					+ "\" Kontostand: \"" + konto.getKontoStand() + "\""
					+ System.lineSeparator();
		}

		MimeMultipart mailContent = new MimeMultipart();
		MimeBodyPart text = new MimeBodyPart();
		text.setText(emailText);
		text.setDisposition(MimeBodyPart.INLINE);
		//
		// File file = new File(defaultPath + "//Groups//" + group.getName()
		// + ".xml");

		// MimeBodyPart attachement = new MimeBodyPart();
		// attachement.setDataHandler(new DataHandler(new
		// FileDataSource(file)));
		// attachement.setFileName(file.getName());
		// attachement.setDisposition(MimeBodyPart.ATTACHMENT);
		mailContent.addBodyPart(text);
		// mailContent.addBodyPart(attachement);

		return mailContent;
	}
}