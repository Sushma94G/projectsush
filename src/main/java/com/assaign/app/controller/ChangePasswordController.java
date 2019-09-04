package com.assaign.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.ChangePasswordDTO;
import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.ChangePasswordService;
import com.assaign.app.service.LoginService;
@Controller
@RequestMapping("/")
public class ChangePasswordController {

	private  final static Logger log = LoggerFactory.getLogger(ChangePasswordController.class);
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	public ChangePasswordController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/changePassword.ams", method=RequestMethod.POST)
	public ModelAndView changePasswordController(ChangePasswordDTO dto){
		
		UserDTO userDTO=changePasswordService.getDataByEmail(dto);
		
		log.info("ChangePasswordController is started");
		
		//log.info(dto.toString());
		
		changePasswordService.changePasswordService(dto);
		
		changePasswordService.updateNewUserService(userDTO);
		
		log.info("ChangePasswordController is ENDED");
		
		return new ModelAndView("home", "msg", "changed").addObject("user", userDTO);
	}
}
