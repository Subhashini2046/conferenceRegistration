package com.ltts.ConferenceRegistration.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltts.ConferenceRegistration.bo.ScheduleBo;
import com.ltts.ConferenceRegistration.model.Schedule;
import com.ltts.ConferenceRegistration.model.User;

@Service
public class ScheduleService {
	@Autowired
	ScheduleBo sb;
	
	@Autowired
	SessionFactory sf;
	
	public boolean insertSchedule(Schedule sc) {
		sb.save(sc);
		return false;	
	}
	
	@Transactional
	public void updateManuscript(String status, int conId) {
	   sb.updateManuscript(status,conId);
	}
	
	@Transactional
	public void updateConference(String status,LocalDate conDate, int conId) {
		sb.updateConference(status,conDate,conId);
	}
	
	public Schedule getScheduleById(int conId) {
		Session s=sf.openSession();
		s.beginTransaction();
		Schedule s1=(Schedule)s.load(Schedule.class,conId);
		s.getTransaction().commit();
		return s1;
	}
	
	public List<Object[]> getUserConferenceStatus(String email){
		return sb.getUserConferenceStatus(email);
	}
	
	public List<Object[]> getListOfPaperTitle(){
		return sb.getListOfPaperTitle();
	}
}
