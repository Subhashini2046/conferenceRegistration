package com.ltts.ConferenceRegistration.bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.ConferenceRegistration.model.Manuscript;
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;

@Repository
public class ConferenceBo {

	@Autowired
	SessionFactory sf;
	
	public boolean insertCon(conference c) {
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
		s.close();
		return false;
	}
	
	public conference getConferenceDetails(int id) {
		Session s = sf.openSession();
		s.beginTransaction();
		conference m = (conference) s.load(conference.class, id);
		s.getTransaction().commit();
		return m;
	}
	
	public List<conference> selectCon() {
		Session s=sf.openSession();
		return s.createQuery("from conference").getResultList();
	}
	
}
