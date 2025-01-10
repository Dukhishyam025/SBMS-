package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
@ResponseBody
public class UserController {

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/email")
	public String sendEmail() throws MessagingException {
//		
//		SimpleMailMessage msg = new SimpleMailMessage();
//		
//		msg.setTo("dastudu25@gmail.com");
//		msg.setSubject("Welcome to Ashok IT");
//		msg.setText("This is email body (test)");
//		
//		mailSender.send(msg);
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setTo("dastudu25@gmail.com");
		helper.setSubject("Welcome to Ashok IT");
		helper.setText("<h1>This is heading</h1>", true);
		
		mailSender.send(msg);
		
		return " Email sent Successfully";
	}
	
}
