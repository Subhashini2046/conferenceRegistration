package com.ltts.ConferenceRegistration.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.ConferenceRegistration.bo.ConferenceBo;
import com.ltts.ConferenceRegistration.bo.ManuscriptBo;
import com.ltts.ConferenceRegistration.bo.ScheduleBo;
import com.ltts.ConferenceRegistration.bo.UserBo;
import com.ltts.ConferenceRegistration.model.Manuscript;
import com.ltts.ConferenceRegistration.model.Schedule;
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;
import com.ltts.ConferenceRegistration.service.FileUploadUtil;
import com.ltts.ConferenceRegistration.service.ScheduleService;


@RestController
public class ScheduleController {
 
	@Autowired
	ScheduleService ss;
	
	@Autowired
	UserBo ub;
	
	@Autowired
	ManuscriptBo mb;
	
	@Autowired
	ConferenceBo cb;
	
	@RequestMapping("/schedule")
	public ModelAndView m1(Model model,@RequestParam String email,@RequestParam int conId) throws IOException {
		User u=ub.checkUserByEmail(email);
		conference con=cb.getConferenceDetails(conId);
		model.addAttribute("email",u.getEmailId());
		model.addAttribute("name",u.getName());
		model.addAttribute("con", con);
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		ModelAndView mv=new ModelAndView("schedule");
		return mv;
	}
	
	
	
	@PostMapping("/insertSchedule")
	public ModelAndView m2(Model model,HttpServletRequest req,@RequestParam String email,@RequestParam int conId)
			throws IOException {
	LocalDate sechduledDate=LocalDate.parse(req.getParameter("sechduledDate"));
	String meetingLink=req.getParameter("meetingLink");
	String meetingPlatform=req.getParameter("meetingPlatform");
	Schedule s=new Schedule(sechduledDate, meetingLink, meetingPlatform, conId,"Scheduled");
    ss.insertSchedule(s);
	ss.updateManuscript("Scheduled", conId);
	ss.updateConference("Scheduled",sechduledDate,conId);
	ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/checkstatus")
	public ModelAndView m3(Model model,@RequestParam String email) throws IOException {
		User u=ub.checkUserByEmail(email);
		model.addAttribute("email",u.getEmailId());
		model.addAttribute("name",u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		System.out.println(email+"+++++++++++++++++++");
		List<Object[]> data = ss.getUserConferenceStatus(email);
		for (Object[] d : data) {
			System.out.println(d[0] + " ");
		}
		model.addAttribute("data", data);
		ModelAndView mv=new ModelAndView("userConfrenceStatus");
		return mv;
	}
}
