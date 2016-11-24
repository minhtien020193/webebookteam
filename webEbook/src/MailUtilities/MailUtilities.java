package MailUtilities;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilities {

	private static final Logger logger = Logger.getLogger(MailUtilities.class.getName());

	private static final String host = "smtp.gmail.com";
	private static final String port = "465";
	private static final String userName = "";
	private static final String password = "";
	private static final String subject = "Check Code";

	public void sendEmailCheckCode(String del_Code, String recipient) {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", port);

		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(del_Code);
			Transport.send(message);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}
}
