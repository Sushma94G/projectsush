package com.assaign.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assaign.app.dao.SearchDAO;
import com.assaign.app.dto.AssignmentDTO;

@Service
public class SearchService {

	@Autowired
	private SearchDAO searchDAO;
	
	public SearchService() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	public List<AssignmentDTO> searchService(String course, String topic){
		
		List<AssignmentDTO> list =searchDAO.searchCourseTopic(course,topic);
		System.out.println("search result: \t" +list);
		
		return  list;
	}
}
