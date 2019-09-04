package com.assaign.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.AssignmentDTO;
import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.CreateAssignmentService;
@Controller
@RequestMapping("/")
public class CreateAssignmentController {
	
	private  final static Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
    private CreateAssignmentService createAssignmentService;
	
	public CreateAssignmentController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/createAssignmnt.ams", method=RequestMethod.POST)
	public ModelAndView createAssignmentController(AssignmentDTO aDTO,HttpServletRequest request){
		
		log.info("CreateAssignment is started");
		
		log.info(aDTO.toString());
		HttpSession session= request.getSession(false);
		if(session.getAttribute("dtoFromDb")!=null)
		{
			createAssignmentService.createAssignmentService(aDTO);
			log.info("CreateAssignmentController is ENDED");
			return new ModelAndView("createAssignment", "pin", "Generated Pin:" +aDTO.getPin());
		}
		else
		{
			System.out.println("session closed");
			return new ModelAndView("signin", "msg", "your session is closed");
		}
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
}
