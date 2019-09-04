package com.assaign.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.assaign.app.controller.SignupController;
import com.assaign.app.dao.CreateAssignmentDAO;
import com.assaign.app.dto.AssignmentDTO;
@Service
public class CreateAssignmentService {

	private  final static Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
    private CreateAssignmentDAO createAssignmentDAO;
	
	public CreateAssignmentService() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
public Integer createAssignmentService(AssignmentDTO aDTO){
		
		Integer generatedPin=generateRandomPin();
		log.info("generated pin is:\t"+generatedPin);
		aDTO.setPin(generatedPin);
		Integer result=createAssignmentDAO.createAssignmentDAO(aDTO);
		
		return result;
	}
public  Integer generateRandomPin() {
		
		Random random =new Random();
		Integer randomNum=random.nextInt(900000+100000);
		return randomNum;
						
}

	
}
