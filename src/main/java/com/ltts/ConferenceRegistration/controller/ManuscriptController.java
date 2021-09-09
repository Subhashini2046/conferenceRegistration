package com.ltts.ConferenceRegistration.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;
import com.ltts.ConferenceRegistration.service.FileUploadUtil;
import com.ltts.ConferenceRegistration.service.ScheduleService;

@RestController
public class ManuscriptController {

	@Autowired
	UserBo ub;
	
	@Autowired
	ManuscriptBo mb;
	
	@Autowired
	ScheduleService ss;
	
	@Autowired
	ConferenceBo cb;
	@RequestMapping("/manuscript")
	public ModelAndView m1(Model model,@RequestParam String email,@RequestParam int conId ) throws IOException {
		System.out.print(conId+"-----------------------------");
		User u=ub.checkUserByEmail(email);
		LocalDate date=LocalDate.now();
		model.addAttribute("email",u.getEmailId());
		model.addAttribute("name",u.getName());
		model.addAttribute("date", date);
		model.addAttribute("conId", conId);
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		List<Object[]> data = ss.getListOfPaperTitle();
		for (Object[] d : data) {
			System.out.println(d[0] + " ");
		}
		model.addAttribute("data", data);
		ModelAndView mv=new ModelAndView("manuscript");
		return mv;
	}
	
	@PostMapping("/insertmanuscript")
	public ModelAndView m2(Model model, @RequestParam("email") String email,@RequestParam("conId") int conId,@RequestParam("manuscriptType") String manuscriptType, @RequestParam("areaOfResearch") String areaOfResearch,
			@RequestParam("titleOfPaper") String titleOfPaper, @RequestParam("NameOfAuthor1") String NameOfAuthor1,
			@RequestParam("restOfTheAuthors") String restOfTheAuthors, @RequestParam("paperfileName") MultipartFile multipartFile)
			throws IOException {
		LocalDate date = LocalDate.now();
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Manuscript m=new Manuscript(manuscriptType, areaOfResearch, titleOfPaper, NameOfAuthor1, restOfTheAuthors,date, email + "_" +fileName,conId,email,"Submitted");
	   mb.insertCon(m);
		System.out.print(m.toString());
		String uploadDir = "D://UploadedPaper/";
		FileUploadUtil.saveFile(uploadDir, email + "_" + fileName, multipartFile);
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
	
//	@RequestMapping("/registeredUser")
//	public ModelAndView m3(Model model,@RequestParam String email,@RequestParam int conId ) throws IOException {
//		System.out.print(conId+"-----------------------------");
//		User u=ub.checkUserByEmail(email);
//		LocalDate date=LocalDate.now();
//		model.addAttribute("email",u.getEmailId());
//		model.addAttribute("name",u.getName());
//		model.addAttribute("date", date);
//		model.addAttribute("conId", conId);
//		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
//		List<Manuscript> list = mb.selectManuscript(conId);
//		System.out.println(list);
//		model.addAttribute("userList", list);
//		ModelAndView mv=new ModelAndView("registeredUserForConference");
//		return mv;
//	}
	
}
