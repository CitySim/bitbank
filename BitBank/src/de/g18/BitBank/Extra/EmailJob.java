package de.g18.BitBank.Extra;

import java.text.NumberFormat;
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

import de.g18.BitBank.Konto;
import de.g18.BitBank.Kunde;

/**
 * Klasse zum Versenden einer E-Mail mit den Kontostaenden.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

class EmailJob {

    // legt die Daten für den Emailserver und den Account zum Versenden fest.
    final void initializeEmailSending(final Kunde kunde, final String email) throws EmailAdresseUngueltigException,
            MessagingException {

        final String username = "bitbank@gmx.de";
        final String password = "bitbank12";
        final String senderAddress = "bitbank@gmx.de";
        final String subject = "BitBank";
        final String smtpHost = "smtp.gmx.net";

        this.sendMail(smtpHost, username, password, senderAddress, subject, kunde, email);
    }

    // versendet Mails
    private void sendMail(
            final String smtpHost,
            final String username,
            final String password,
            final String senderAddress,
            final String subject,
            final Kunde kunde,
            final String emailAdress) throws EmailAdresseUngueltigException, MessagingException {

        final Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        final MailAuthenticator auth = new MailAuthenticator(username, password);
        final Session session = Session.getDefaultInstance(properties, auth);

        final Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(senderAddress));

        msg.setSubject(subject);
        msg.setHeader("GroupBuilder", "GroupBuilder");
        msg.setSentDate(new Date());
        MimeMultipart mailContent;

        mailContent = this.generateMailContent(kunde);

        msg.setContent(mailContent);

        if (emailAdress != null && !emailAdress.equals("")) {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAdress, false));
            try {
                Transport.send(msg);
            } catch (final javax.mail.SendFailedException e) {
                throw new EmailAdresseUngueltigException(emailAdress);
            }
        }

    }

    // hilft beim einloggen bei dem Konto.
    private class MailAuthenticator extends Authenticator {

        private final String user;
        private final String password;

        public MailAuthenticator(final String user, final String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.password);
        }
    }

    private MimeMultipart generateMailContent(final Kunde kunde) throws MessagingException {

        String emailText = "Sehr geehrte(r) " + kunde.getName() + ",\r\n" + "\r\n"
                + "Hierbei handelt es sich um eine automatisch generierte E-Mail von BitBank." + "\r\n" + "\r\n"
                + "Anbei Ihre aktuelle Kontostandsübersicht:" + "\r\n" + "\r\n";

        if (kunde.getKontenListe().size() != 0) {
            for (final Konto konto : kunde.getKontenListe()) {
                emailText = emailText + "Konto: " + konto.getKontoNummer() + " Kontotyp: " + konto.getKontoTyp()
                        + " Kontostand: " + NumberFormat.getCurrencyInstance().format(konto.getKontoStand()) + "\r\n";
            }
        } else {
            emailText = emailText + "Sie verfügen bisher über kein Konto bei uns.";
        }
        emailText = emailText + "\r\n" + "\r\n" + "Bitte beehren Sie uns bald wieder!";

        final MimeMultipart mailContent = new MimeMultipart();
        final MimeBodyPart text = new MimeBodyPart();
        text.setText(emailText);
        text.setDisposition(MimeBodyPart.INLINE);
        mailContent.addBodyPart(text);

        return mailContent;
    }
}
