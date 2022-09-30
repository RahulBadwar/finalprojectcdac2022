package com.bookmybus.Bookmybus.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
public void sendEmail(String message, String subject, String to, String from) {
		
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("bookmybuscdac@gmail.com", "dedxhumngjyrkbld");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		m.setFrom(from);
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		m.setSubject(subject);
	
		m.setText(message);
		
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
