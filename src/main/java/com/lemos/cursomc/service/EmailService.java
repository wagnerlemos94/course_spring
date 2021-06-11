package com.lemos.cursomc.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.lemos.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
}
