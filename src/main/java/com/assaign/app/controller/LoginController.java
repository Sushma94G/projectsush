package com.assaign.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.LoginDTO;
import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.LoginService;
import com.assaign.util.EncryptionDecryption;
@Controller
@RequestMapping("/")
public class LoginController {

	private  final static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	public LoginController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/signin.ams", method=RequestMethod.POST)
	public ModelAndView loginController(LoginDTO loginDTO,HttpServletRequest request){
		
		log.info("LoginController is started");
		log.info(loginDTO.toString());
		UserDTO dtoFromDb= loginService.loginService(loginDTO);
		
		log.info("dtoFromDb-->"+dtoFromDb);
		
		if(dtoFromDb != null){
			String passFromLogin=loginDTO.getPassword();
			String decryptedPass=EncryptionDecryption.decrypt(dtoFromDb.getPassword());
			System.err.println("passFromLogin" + passFromLogin);
			System.err.println("decryptedPass" + decryptedPass);
			if(passFromLogin.equals(decryptedPass))
			{
				if(dtoFromDb.isNewUser())
				{
					return new ModelAndView("changePassword.jsp");
				}
				else{
				
				 log.info("Login successful");
				 HttpSession session= request.getSession(true);
				 session.setMaxInactiveInterval(10);
				 
				 session.setAttribute("dtoFromDb", dtoFromDb);
				 loginService.updateLastLoginAndFailCountService(dtoFromDb);
				 return new ModelAndView("home.jsp", "msg", "login successful").addObject("user", dtoFromDb);
				}
			}
			else{
				log.info("Incorrect Password");
				
				int failCount = dtoFromDb.getFailCount();
				dtoFromDb.setFailCount(failCount+1);
				
				loginService.failedLoginService(dtoFromDb);
				
				return new ModelAndView("signin", "msg", "Incorrect password");
			}
		}else{
			log.info("wrong email id");
			return new ModelAndView("signin", "msg", "wrong email id");
		}
	}
	
	@RequestMapping(value="logout.ams", method=RequestMethod.GET)
	public ModelAndView logoutController(HttpServletRequest request)
	{
		HttpSession session= request.getSession(false);
		session.invalidate();
		System.out.println("logout sucessful, session closed");
		return new ModelAndView("signin", "msg", "user is loggedout");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
