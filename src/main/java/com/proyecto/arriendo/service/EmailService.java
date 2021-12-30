package com.proyecto.arriendo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public void sendEmail(String to, String titulo, String mensaje)
	{
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(to);
		email.setSubject(titulo);
		email.setText(mensaje);
		
		mailSender.send(email);
	}
}
