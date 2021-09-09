package com.ltts.ConferenceRegistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.ConferenceRegistration.bo.UserBo;
import com.ltts.ConferenceRegistration.model.User;

@Service
public class UserService {
	
	@Autowired
	UserBo ub;
	
//	public User insertUser(User u) {
//		return ub.save(u);
//	}
//	public Optional<User> checkUserByEmail(String email) {
//		return ub.findById(email);
//	}
}
