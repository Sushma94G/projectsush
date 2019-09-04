package com.assaign.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.SignupService;
@Controller
@RequestMapping("/")
public class SignupController {

	private  final static Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private SignupService signupService;
	
	public SignupController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/signup.ams", method=RequestMethod.POST)
	public ModelAndView signupController(UserDTO userDTO){
		//System.out.println("SignupController is started");
		log.info("SignupController is started");
		
		//System.out.println(userDTO);
		log.info(userDTO.toString());
		String result= signupService.signupService(userDTO);
		
		//System.out.println("SignupController is ENDED");
		log.info("SignupController is ENDED");
		
		return new ModelAndView("index", "msg", result);
	}
}
