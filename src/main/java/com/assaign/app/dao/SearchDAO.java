package com.assaign.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assaign.app.dto.AssignmentDTO;
import com.assaign.app.service.AssignService;

@Repository
public class SearchDAO {
	
	@Autowired
	private SessionFactory factory;

	public SearchDAO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	 public List<AssignmentDTO> searchCourseTopic(String course,String topic){
    	
		 System.out.println("searchDAO started");
		 String hql="from AssignmentDTO where course=:cr and topic=:tp";
		 
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		 Query query=session.createQuery(hql);
		 query.setParameter("cr", course);
		 query.setParameter("tp", topic);
		 List<AssignmentDTO> list = query.list();
		 
		
		 
		 
		 return list;
    	 
	 }
}
