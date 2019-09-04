package com.assaign.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assaign.app.dto.AssignmentDTO;

import com.assaign.app.service.SearchService;

@Controller
@RequestMapping("/")
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	public SearchController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/search.ams", method=RequestMethod.POST)
	public ModelAndView searchController(HttpServletRequest request){
		
		String course=request.getParameter("course");
		String topic=request.getParameter("topic");
		
		List<AssignmentDTO> list= searchService.searchService(course,topic);
		return new ModelAndView("search", "list", list);
	}
}
