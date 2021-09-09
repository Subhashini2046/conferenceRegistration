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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.ConferenceRegistration.bo.ConferenceBo;
import com.ltts.ConferenceRegistration.bo.UserBo;
import com.ltts.ConferenceRegistration.model.Schedule;
import com.ltts.ConferenceRegistration.model.User;
import com.ltts.ConferenceRegistration.model.conference;
import com.ltts.ConferenceRegistration.service.FileUploadUtil;
import com.ltts.ConferenceRegistration.service.ScheduleService;

@RestController
public class userController {

	@Autowired
	UserBo ub;

	@Autowired
	ConferenceBo cb;

	@Autowired
	ScheduleService ss;

	@RequestMapping("/")
	public ModelAndView m1() {
		return new ModelAndView("login");
	}

	@RequestMapping("/logout")
	public ModelAndView m3() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/login")
	public ModelAndView m10() {
		return new ModelAndView("login");
	}

	@RequestMapping("/registration")
	public ModelAndView m2(Model model) {
		LocalDate date = LocalDate.now();
		//LocalDate tDate = date.plusDays(1);
		model.addAttribute("tdate", date);
		ModelAndView mv = new ModelAndView("registration");
		return mv;
	}

	@RequestMapping("/updateuser")
	public ModelAndView m4(Model model, @RequestParam("email") String email) throws IOException {
		User u = ub.checkUserByEmail(email);
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		model.addAttribute("user", u);
		ModelAndView mv = new ModelAndView("updateUser");
		return mv;
	}
	
	@RequestMapping("/updateuserdata")
	public ModelAndView m6(Model model, @RequestParam("email") String email) throws IOException {
		User u = ub.checkUserByEmail(email);
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		model.addAttribute("user", u);
		ModelAndView mv = new ModelAndView("updateUserData");
		return mv;
	}
	
	@PostMapping("/updateuserdatadetails")
	public ModelAndView UpdateUserData(Model model, @RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("dob") String dob, @RequestParam("mobile") String mobile,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		User us = ub.checkUserByEmail(email);
		LocalDate dob1 = LocalDate.parse(dob);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	
		if (fileName.equals("")) {
			User user = new User(name, dob1, email, us.getPassword(), mobile, us.getPhoto(), us.getUserRole());
			ub.updateUser(user);
			System.out.print(user.toString());
		} else {
			User user = new User(name, dob1, email, us.getPassword(), mobile, email + "_" + fileName, us.getUserRole());
			ub.updateUser(user);
			System.out.print(user.toString());
			String uploadDir = "D://user-photos/";
			FileUploadUtil.saveFile(uploadDir, email + "_" + fileName, multipartFile);
		}
		User u = ub.checkUserByEmail(email);
		model.addAttribute("name", u.getName());
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		List<conference> list = cb.selectCon();
		System.out.println(list);
		model.addAttribute("conList", list);
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@PostMapping("/updateuserdetails")
	public ModelAndView UpdateUser(Model model, @RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("dob") String dob, @RequestParam("mobile") String mobile,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		User us = ub.checkUserByEmail(email);
		LocalDate dob1 = LocalDate.parse(dob);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	
		if (fileName.equals("")) {
			User user = new User(name, dob1, email, us.getPassword(), mobile, us.getPhoto(), us.getUserRole());
			ub.updateUser(user);
			System.out.print(user.toString());
		} else {
			User user = new User(name, dob1, email, us.getPassword(), mobile, email + "_" + fileName, us.getUserRole());
			ub.updateUser(user);
			System.out.print(user.toString());
			String uploadDir = "D://user-photos/";
			FileUploadUtil.saveFile(uploadDir, email + "_" + fileName, multipartFile);
		}
		User u = ub.checkUserByEmail(email);
		model.addAttribute("name", u.getName());
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		List<conference> list = cb.selectCon();
		System.out.println(list);
		model.addAttribute("conList", list);
		ModelAndView mv = new ModelAndView("conHome");
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView m5(Model model, @RequestParam("email") String email) throws IOException {
		User u = ub.checkUserByEmail(email);
		model.addAttribute("email", u.getEmailId());
		model.addAttribute("name", u.getName());
		model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
		model.addAttribute("user", u);
		List<conference> list = cb.selectCon();
		System.out.println(list);
		model.addAttribute("conList", list);
		ModelAndView mv = new ModelAndView("conHome");
		return mv;
	}
	@PostMapping("/insertuser")
	public ModelAndView insertUser(Model model, @RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("dob") String dob,
			@RequestParam("mobile") String mobile, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		LocalDate dob1 = LocalDate.parse(dob);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		User user = new User(name, dob1, email, password, mobile, email + "_" +fileName, "USER");
		//User user = new User(name, dob1, email, password, mobile, email + "_" + fileName, "INCHARGE");
		ub.insertUser(user);
		System.out.print(user.toString());
		String uploadDir = "D://user-photos/";
		FileUploadUtil.saveFile(uploadDir, email + "_" + fileName, multipartFile);
		model.addAttribute("r1", "Registration Successfull !!");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

//	@RequestMapping(value = "/usercheck/check",method = RequestMethod.POST)
//	public ModelAndView m13(Model model, HttpServletRequest request) {
//		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//		return new ModelAndView("home");
//		
//	}
	@RequestMapping(value = "/checkuser")
	public ModelAndView m9(Model model, HttpServletRequest request) throws Exception {
		ModelAndView mv = null;
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		String uemail = request.getParameter("email");
		String mobile = request.getParameter("password");
		System.out.print(uemail+"     "+mobile);
		try {
			User u = ub.checkUserByEmail(uemail);
			System.out.println("vvvvvvvvvvvvvvv");
			System.out.println("eeeeeeeeeeeeeee");
			System.out.print(u.toString());
			if (u.equals(null)) {
				model.addAttribute("msg", "Your user name is wrong");
				mv = new ModelAndView("login");
			}
			if (u.getEmailId().equals(uemail)) {
				if (mobile.equals(u.getPassword())) {
					model.addAttribute("name", u.getName());
					model.addAttribute("email", u.getEmailId());
					model.addAttribute("userPhoto", FileUploadUtil.convertFileIntoBase64String(u.getPhoto()));
					System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
					if (u.getUserRole().equals("INCHARGE")) {
						List<conference> list = cb.selectCon();
						System.out.println(list);
						// Schedule s=ss.getScheduleById(conId);
						model.addAttribute("conList", list);
						System.out.println("hyyyyyyyyyyyyyyyyyyy");
						mv = new ModelAndView("conHome");
					} else {
						List<conference> list = cb.selectCon();
						System.out.println(list);
						model.addAttribute("conList", list);
						mv = new ModelAndView("home");
					}
				} else {
					model.addAttribute("msg", "Your user password is wrong");
					mv = new ModelAndView("login");
				}
			} else {
				model.addAttribute("msg", "Your user name is wrong");
				mv = new ModelAndView("login");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "Your user name is wrong");
			mv = new ModelAndView("login");
		}
		return mv;
	}

}
