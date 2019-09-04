package com.assaign.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assaign.app.dao.AssignDAO;
import com.assaign.app.dto.AssignmentDTO;
import com.assaign.app.dto.UserDTO;

@Service
public class AssignService {

	@Autowired
	private AssignDAO assignDAO;
	
	@Autowired
	private MailSender sender;
	
	public AssignService() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	public boolean assignService(int pin, String emails){
		
		//if(emails !=null)
		// {
			String[] emailArray = emails.split(",");
			AssignmentDTO aDTO =assignDAO.checkPin(pin);
			if(aDTO!=null){
			for(int i=0;i<emailArray.length;i++)
			{
			sendMail(aDTO,emailArray[i]);	
			}
			}else{
				return false;
			}
		// }
		return true;
	}
	
	 public String sendMail(AssignmentDTO aDTO,String email){
	    	
	    	SimpleMailMessage simpleMessage = new SimpleMailMessage();
	    	simpleMessage.setTo(email);
	    	simpleMessage.setSubject("Your New Task: Assignment");
	    
	    	simpleMessage.setText("Course: " +aDTO.getCourse()+"\n Topic: " +aDTO.getTopic()+"\n Description: " +aDTO.getDescription()+"\n DeadLine:" +aDTO.getDeadLine()+"\n UploadType: "+aDTO.getUploadType());
	    	
	    	sender.send(simpleMessage);
	    	
	    	return "mail sent to"+email;
	    	
	    }
	
}

