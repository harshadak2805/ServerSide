package com.user.role.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.user.role.custom.exception.RecordNotFoundException;
import com.user.role.model.User;
import com.user.role.model.UserRoll;
import com.user.role.repository.UserRepository;
import com.user.role.service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String NO_RECORD_FOUND_MSG = "No record found in database";
	
	@Override
	public User signUp(User user) {
		logger.info("create User");
		User userObj = null;
		try {
			userObj = userRepository.save(user);
		}catch (DataIntegrityViolationException e) {
			logger.error("Record not saved, somthing went wrong please contact to support "+e.getMessage());
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		}
		return userObj;
	}

	@Override
	public User signIn(User user) {
		logger.info("sign in User");

		User userObj = null;
		try {
			userObj = userRepository.signIn(user.getUserName(),user.getPassword());
		}catch (DataIntegrityViolationException e) {
			logger.error("Record not saved, somthing went wrong please contact to support "+e.getMessage());
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		}
		return userObj;
	}

	@Override
	public List<User> getUsersByAuthType(String authType) {
		logger.info("getUsersByAuthType in User");
		List<User> userList=new ArrayList<User>();
		String authorize="N";
		
		if(authType.equalsIgnoreCase("auth")) {
			authorize = "Y";
			userList = (List<User>) userRepository.getUsersByAuthType(authorize);
		}else if(authType.equalsIgnoreCase("unauth")) {
			authorize = "N";
			userList = (List<User>) userRepository.getUsersByAuthType(authorize);
		}else if(authType.equalsIgnoreCase("All")) {
			userList = (List<User>) userRepository.findAll();
		}
		
		if (userList.isEmpty()) {
			logger.error(NO_RECORD_FOUND_MSG);
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		} else {
			return userList;
		}
	}

	@Override
	public List<User> getUserByName(String userName) {
		List<User> userList=new ArrayList<User>();


			userList = userRepository.getUsersByName(userName);


		if(userList.isEmpty()){
			logger.error(NO_RECORD_FOUND_MSG);
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		}else{
			return userList;
		}
	}

	public User approveUser(Integer userId){
		Optional<User> existingUser = userRepository.findById(userId);
		User users= existingUser.get();
		users.setAuthorize("Y");
		users.setApproveUser(true);
		User updatedUser = userRepository.save(users);
		return updatedUser;
	}

	public User approveUserRequest(Integer userId, boolean isApprove){
		Optional<User> existingUser = userRepository.findById(userId);
		User users= existingUser.get();
		users.setApproveUser(isApprove);
		User updatedUser = userRepository.save(users);
		return updatedUser;

	}

	public List<User> getUsersRequest(){
		List<User> userList=new ArrayList<User>();
		boolean approveUser=true;
		char c='N';
		String authorize = Character.toString(c);
		userList= userRepository.getUsersRequest(authorize,approveUser);
		return userList;
	}


}
