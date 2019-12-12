package com.flight.reservation.flightreservation.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailService {
	private Email from;
	private SendGrid sendGrid;
	public EmailService(String fromMail,String key) {
		from=new Email(fromMail);
		sendGrid=new SendGrid(key);
	}
  
	
	public void send(Email to,String content,String subject ) {
		Request request = new Request();
	    try {
	    	Content emailContent=new Content();
	    	emailContent.setValue(content);
	    	emailContent.setType("text/html");
		      Mail mail = new Mail(from, subject, to, emailContent);
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sendGrid.api(request);
	      System.out.println("Email Send successfully");
	    } catch (IOException ex) {
	    	System.out.println("Unable to send email: "+ex.getMessage());
	    }
	}
	
	
	public static void main(String[] args) {
		EmailService emailService=new EmailService("info@backbook.in", "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");
	 String BACKBOOK_EMAIL_FOOTER="\nThanks & Regards,\n"+
				"Backbook Team\n"+
				"www.backbook.in\n"+
				"reach out to us on info@backbook.in, <a style=\" background: url(https://backbook.in/assets/social-icon.0bac84b2524a341d53a5.png) no-repeat left top;    height: 48px; width: 48px; list-style-type: none;display: inline-block;background-size: cover; cursor: pointer;    background-position: -60px 5px;\" href=\"https://www.facebook.com/back.book.37604\" target=\"_blank\"></a>, "
				+ "<a style=\" background: url(https://backbook.in/assets/social-icon.0bac84b2524a341d53a5.png) no-repeat left top;    height: 48px; width: 48px; list-style-type: none;display: inline-block;background-size: cover; cursor: pointer;    background-position: -6px 5px;\" href=\"https://twitter.com/backbook7\" target=\"_blank\"></a>, "
				+ "<a style=\" background: url(https://backbook.in/assets/social-instagram.f1f70c44638afd35b6f1.png) no-repeat left top;    height: 40px; width: 40px; list-style-type: none;display: inline-block;background-size: cover; cursor: pointer; \" href=\"https://www.instagram.com/backbook.in/?hl=en\" target=\"_blank\"></a>";
		emailService.send(new Email("ishwarya.2k7@gmail.com"), BACKBOOK_EMAIL_FOOTER, "TEST");
	}
}
