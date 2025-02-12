package org.jsp.ecommerce.util;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class Helper {
	@Autowired
	private JavaMailSender jms;

	@Value("${spring.mail.username}")
	private String Usermail;

	public void sendMail(String receipt, String body, String Subject) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(receipt);
		smm.setFrom(Usermail);
		smm.setText(body);
		smm.setSubject(Subject);
		jms.send(smm);
	}

	public boolean sendFirstMail(String email, int otp) {
		MimeMessage mimeMessage = jms.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(email);
			helper.setSubject("Account Created");
			String htmlContent = "<html> <body style='background:cyan;'> <h1 style='margin:auto; '>" + otp
					+ "</h1> </body> </html>";
			helper.setText(htmlContent, true);
		} catch (MessagingException e) {
			System.out.println("Invalid Email Id");
			return false;
		}
		try {
			jms.send(mimeMessage);
		} catch (MailException e) {
			System.out.println("Invalid Email Id");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int OTPGenerator() {
		double otp = Math.random() * 10000;
		while (otp < 1000) {
			otp = Math.random() * 10000;
		}
		return (int) (otp);
	}

	public static String generateOTP(int length) {
		SecureRandom random = new SecureRandom();
		StringBuilder otp = new StringBuilder();

		for (int i = 0; i < length; i++) {
			otp.append(random.nextInt(10));
		}
		return otp.toString();
	}

}
