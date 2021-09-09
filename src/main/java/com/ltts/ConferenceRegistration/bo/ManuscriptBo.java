package com.ltts.ConferenceRegistration.bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.ConferenceRegistration.model.Manuscript;
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;

@Repository
public class ManuscriptBo {
	@Autowired
	SessionFactory sf;

	public boolean insertCon(Manuscript m) {
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(m);
		s.getTransaction().commit();
		s.close();
		return false;
	}

	public Manuscript getManuscriptDetails(int id) {
		Session s = sf.openSession();
		s.beginTransaction();
		Manuscript m = (Manuscript) s.load(Manuscript.class, id);
		s.getTransaction().commit();
		return m;
	}

	public List<Manuscript> selectManuscript(int conId) {
		Session s = sf.openSession();
		return s.createQuery("from Manuscript where con_id_fk=" + conId + "").getResultList();
	}

}
