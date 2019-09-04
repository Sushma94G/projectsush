package com.assaign.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.AssignService;

@Controller
@RequestMapping("/")
public class AssignController {
	
	@Autowired
	private AssignService assignService;

	public AssignController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/assign.ams", method=RequestMethod.POST)
	public ModelAndView assignController(HttpServletRequest request){
		
		Integer pin=Integer.parseInt(request.getParameter("pin"));
		String emails=request.getParameter("emails");
		
		boolean status=assignService.assignService(pin,emails);
		if (status) {
			return new ModelAndView("assign", "msg", "Assign successful");
		} else {
			return new ModelAndView("assign", "err", "Assignment Pin is incorrect");
		}
		
		
		
	}
	
}
