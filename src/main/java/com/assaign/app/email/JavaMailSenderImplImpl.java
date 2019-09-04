package com.assaign.app.email;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class JavaMailSenderImplImpl extends JavaMailSenderImpl{

	
	public JavaMailSenderImplImpl(String password) {
		// TODO Auto-generated constructor stub
		super.setPassword(password);
	}
}
