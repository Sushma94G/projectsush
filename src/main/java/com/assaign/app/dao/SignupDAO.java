package com.assaign.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assaign.app.dto.UserDTO;
import com.assaign.app.service.SignupService;
@Repository
public class SignupDAO {

	@Autowired
	private SessionFactory factory;
	
	public SignupDAO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	 public String signupDAO(UserDTO userDTO){
		 System.out.println("SignupDAO started");
		 String hql="from UserDTO where email=:em";
		 
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		 Query query=session.createQuery(hql);
		 query.setParameter("em", userDTO.getEmail());
		 
		UserDTO dtoFromDB=(UserDTO) query.uniqueResult();
		 if(dtoFromDB !=null)
		 {
			 System.out.println("emaiId is already present");
			 return "email id is already present";
		 }
		 else{
			 session.save(userDTO);
			 
			 transaction.commit();
			 System.out.println("SignupDAO ended");
			 return "user created successfully";
		 }
		
	 }
		
}
