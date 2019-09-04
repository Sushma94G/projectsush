package com.assaign.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assaign.app.dto.AssignmentDTO;
import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.AssignService;

@Repository
public class AssignDAO {
	
	@Autowired
	private SessionFactory factory;

     public AssignDAO() {
	      System.out.println("Created \t"+this.getClass().getSimpleName());
     }
     
     public AssignmentDTO checkPin(int pin){
    	 System.out.println("AssignDAO started");
		 String hql="from AssignmentDTO where pin=:pn";
		 
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		 Query query=session.createQuery(hql);
		 query.setParameter("pn", pin);
		 
		AssignmentDTO aDTO= (AssignmentDTO) query.uniqueResult();
		return aDTO;
     }
	
}
