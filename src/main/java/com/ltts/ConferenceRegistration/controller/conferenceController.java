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
import com.ltts.ConferenceRegistration.bo.UserBo;
import com.ltts.ConferenceRegistration.model.Manuscript;
import com.ltts.ConferenceRegistration.model.Schedule;
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;
import com.ltts.ConferenceRegistration.service.FileUploadUtil;
import com.ltts.ConferenceRegistration.service.ScheduleService;

@RestController
public class conferenceController {
	@Autowired
	ConferenceBo cb;

	@Autowired
	UserBo ub;
	
	@Autowired
	ManuscriptBo mb;

	@RequestMapping("/userhome")
	public ModelAndView m1(Model model, @RequestParam String email) throws IOException {
		User u = ub.checkUserByEmail(email);
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		List<conference> list = cb.selectCon();
		System.out.println(list);
		model.addAttribute("conList", list);
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("/createcon")
	public ModelAndView m2(Model model, @RequestParam String email) throws IOException {
		User u = ub.checkUserByEmail(email);
		LocalDate date = LocalDate.now();

		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("date", date);
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		ModelAndView mv = new ModelAndView("createConference");
		return mv;
	}

	@PostMapping("/insertcon")
	public ModelAndView insertMovie(Model model, HttpServletRequest req, @RequestParam String email)
			throws IOException {
		User u = ub.checkUserByEmail(email);

		String title = req.getParameter("title");
		String publicationIssue = req.getParameter("publicationIssue");
		LocalDate submissionDeadline = LocalDate.parse(req.getParameter("submissionDeadline"));
		LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
		conference con = new conference(title, publicationIssue, submissionDeadline, startDate, endDate);
		cb.insertCon(con);
		System.out.print(con.toString());
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		
		ModelAndView mv = new ModelAndView("conHome");
		return mv;
	}

	@RequestMapping("/registeredUser")
	public ModelAndView m3(Model model, @RequestParam String email, @RequestParam int conId) throws IOException {
		System.out.print(conId + "-----------------------------");
		User u = ub.checkUserByEmail(email);
		LocalDate date = LocalDate.now();
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("date", date);
		model.addAttribute("conId", conId);
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		List<Manuscript> list = mb.selectManuscript(conId);
		System.out.println(list);
		model.addAttribute("userList", list);
		ModelAndView mv = new ModelAndView("registeredUserForConference");
		return mv;
	}
}
