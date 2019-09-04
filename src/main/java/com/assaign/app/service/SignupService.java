package com.assaign.app.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assaign.app.dao.SignupDAO;
import com.assaign.app.dto.UserDTO;
import com.assaign.util.EncryptionDecryption;
import com.assaign.util.GenerateRandomPassword;
@Service
public class SignupService {

	private  final static Logger log = LoggerFactory.getLogger(SignupService.class);
	
	@Autowired
	private SignupDAO signupDAO;
	
	@Autowired
	private MailSender sender;
	
	@Autowired
	private GenerateRandomPassword randomPassword;
	
	@Autowired
	private EncryptionDecryption encryptDecrypt;

	
	public SignupService() {
		System.out.println("Created \t"+this.getClass().getSimpleName());

	}
	
    public String signupService(UserDTO userDTO){
		System.out.println("SignupService started");
		userDTO.setNewUser(true);
		
		//generated random password
		
		//userDTO.setPassword(randomPassword.generatePassword());
		
		String password = randomPassword.generatePassword();
		System.err.println("password generated \t" + password);
		String pwdfromEncrypt = encryptDecrypt.encrypt(password);
		System.err.println("password encrypted\t" + pwdfromEncrypt);
		userDTO.setPassword(pwdfromEncrypt);
		
		log.info(userDTO.toString());
		//String pwdfromEncrypt = encryptDecrypt.encrypt(password);
		String result=signupDAO.signupDAO(userDTO);
		
		
		
		//mail
		/*String email =userDTO.getEmail();
		String password=userDTO.getPassword();
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(email);
		simpleMessage.setSubject("Confirmation mail from ASSAIGNMENT MANAGEMENT SYSTEM");
		simpleMessage.setText("Your account is created \n Please login by using\n email :\n" +email+"password: \n"+password);
		
		sender.send(simpleMessage);*/
		
		String email =userDTO.getEmail();
		password=userDTO.getPassword();
		 String decryptPWD = encryptDecrypt.decrypt(password);
		String subject="Confirmation mail from ASSAIGNMENT MANAGEMENT SYSTEM";
		String text="Your account is created \n Please login by using\n email :" +email+" \n password: "+decryptPWD;
		
		String emailResult=sendMail(email,subject,text,decryptPWD);
		System.err.println("sentDecryptPwd :  " +decryptPWD);
		log.info(emailResult.toString());
		
	    log.info("SignupService ENDED");
	    return result;
	}
    
    public String sendMail(String to,String subject,String text,String password){
    	
    	SimpleMailMessage simpleMessage = new SimpleMailMessage();
    	simpleMessage.setTo(to);
    	simpleMessage.setSubject(subject);
    	simpleMessage.setText(text);
    	
    	sender.send(simpleMessage);
    	
    	return "mail sent to"+to;
    	
    }
}
