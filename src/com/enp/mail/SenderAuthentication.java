package com.enp.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SenderAuthentication extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return (new PasswordAuthentication(
				"rameshspes@gmail.com",
				"davangere123"));
	}
}
