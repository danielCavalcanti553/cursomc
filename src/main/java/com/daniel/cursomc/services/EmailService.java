package com.daniel.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
	void sendNewPasswordEmail(Cliente cliente,String newPass);
}
