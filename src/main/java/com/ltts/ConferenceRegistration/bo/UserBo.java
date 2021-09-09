package com.ltts.ConferenceRegistration.bo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.ConferenceRegistration.model.User;


@Repository
public class UserBo{
	
	@Autowired
	SessionFactory sf;
	
	public boolean insertUser(User u) {
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		return false;
	}
	
	public boolean updateUser(User u) {
		Session s=sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(u);
		s.getTransaction().commit();
		s.close();
		return false;
	}
	
	public User checkUserByEmail(String email) {
		Session s=sf.openSession();
		s.beginTransaction();
		User u1=(User)s.load(User.class,email);
		s.getTransaction().commit();
	//	System.out.println("ffffffffffffffffffffffffffff");
		return u1;
	}
}
