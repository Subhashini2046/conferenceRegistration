package com.ltts.ConferenceRegistration.bo;

import java.time.LocalDate;
import java.util.List;




import org.springframework.stereotype.Repository;
import com.ltts.ConferenceRegistration.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ScheduleBo extends JpaRepository<Schedule, Integer>{

	
	@Modifying
	@Query(value ="update Manuscript set status=:status where con_id_fk=:conId", nativeQuery = true)
	void updateManuscript(@Param(value = "status") String status, @Param(value = "conId") int conId);
	
	@Modifying
	@Query(value ="update Conference set status=:status, con_date=:conDate where con_id=:conId", nativeQuery = true)
	void updateConference(@Param(value = "status") String status, @Param(value = "conDate") LocalDate conDate ,@Param(value = "conId") int conId);
	
	@Query(value ="select name_of_author1,area_of_research,manuscript.status,date_of_submittion,paperfile_name,sechduled_date,rest_of_the_authors,title_of_paper,user_email_fk,meeting_link,meeting_platform from manuscript inner join schedule on(manuscript.con_id_fk=schedule.con_id_pk) where user_email_fk=:email", nativeQuery = true)
	public List<Object[]> getUserConferenceStatus(@Param("email") String email);
	
	@Query(value ="select title_of_paper from manuscript;", nativeQuery = true)
	public List<Object[]> getListOfPaperTitle();
	
//	@Autowired
//	SessionFactory sf;
//	public boolean insertSchedule(Schedule sc) {
//		Session s = sf.openSession();
//		s.beginTransaction();
//		s.save(sc);
//		s.getTransaction().commit();
//		s.close();
//		return false;
//	}
//	
//	@Transactional
//	public boolean updateManuscript(int conId) {
//		SessionFactory factory = HibernateUtility.getSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        String qryString2 = "update Manuscript set status=:n where con_id_fk=:i";
//        Query query2 = session.createQuery(qryString2);
//        //query2.setParameter(0, 1);
//        query2.setParameter("n","Scheduled");  
//        query2.setParameter("i",conId);  
//        query2.executeUpdate();
//        int count2 = query2.executeUpdate();
//        System.out.println(count2 + " Record(s) Updated.");
//        transaction.commit();
//        session.clear();
//        session.close();
//        System.out.println("Transaction Completed !");
//		return false;
//	}
}
