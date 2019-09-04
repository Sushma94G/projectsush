package com.assaign.app.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assaign.app.dto.ChangePasswordDTO;
import com.assaign.app.dto.LoginDTO;
import com.assaign.app.dto.UserDTO;
@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public LoginDAO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	public UserDTO loginDAO(LoginDTO loginDTO){
		
		String hql="from UserDTO where email=:em";
        Session session=sessionFactory.openSession();
		
		 Query query=session.createQuery(hql);
		 query.setParameter("em", loginDTO.getEmail());
		 
		UserDTO dtoFromDB=(UserDTO) query.uniqueResult();
		
		return dtoFromDB;
	}
	
	public void updateLastLoginAndFailCountDAO(String email, Date date,int failCount,boolean newUser){
		String hql="update UserDTO set lastLogin=:ll, failCount=:fc ,newUser=:nu where email=:em";
        Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		 Query query=session.createQuery(hql);
		 query.setParameter("ll", date);
		 query.setParameter("fc", failCount);
		 query.setParameter("nu", newUser);
		 query.setParameter("em", email);
		 
		 query.executeUpdate();
		 transaction.commit();
	}
	
	public void failedLoginDAO(UserDTO dtoFromDb){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(dtoFromDb);
		
		transaction.commit();
	}
	
	
}
