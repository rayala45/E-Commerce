package org.jsp.ecommerce.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class Helper {
	
	private JavaMailSender jms;
	
	@Value("${spring.mail.username}")
	private String Usermail;
	
	public void sendMail(String receipt,String body,String Subject) {
		SimpleMailMessage smm=new SimpleMailMessage();
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
	
	
	public static int OTPGenerator() {
		double otp=Math.random();
		while(otp*10000>1000) {
			return (int)(otp);
		}
		return OTPGenerator();
	}

}
