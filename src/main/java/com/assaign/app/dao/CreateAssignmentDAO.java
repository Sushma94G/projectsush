package com.assaign.app.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assaign.app.dto.AssignmentDTO;
import com.assaign.app.dto.LoginDTO;
import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.CreateAssignmentService;
@Repository
public class CreateAssignmentDAO {

	@Autowired
    private SessionFactory factory;
	
	public CreateAssignmentDAO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
public Integer createAssignmentDAO(AssignmentDTO aDTO){
		
        Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		Serializable id=session.save(aDTO);
        tx.commit();
		return (Integer) id;
			
	}
	
	
}
