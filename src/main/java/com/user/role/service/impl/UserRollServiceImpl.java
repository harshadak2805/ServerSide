package com.user.role.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.user.role.custom.exception.RecordNotFoundException;
import com.user.role.model.UserRoll;
import com.user.role.repository.UserRollRepository;
import com.user.role.service.UserRollService;

import ch.qos.logback.classic.Logger;

@Service
public class UserRollServiceImpl implements UserRollService {

	@Autowired
	private UserRollRepository userRollRepository;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserRollServiceImpl.class);
	private static final String NO_RECORD_FOUND_MSG = "No record found in database";
	
	@Override
	public List<UserRoll> getAllUserRoll() {
		List<UserRoll> userRollList = (List<UserRoll>) userRollRepository.findAll();
		if (userRollList.isEmpty()) {
			logger.error(NO_RECORD_FOUND_MSG);
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		} else {
			return userRollList;
		}
	}

	@Override
	public UserRoll createRole(UserRoll userRoll) {
		logger.info("create User");
		UserRoll userRollObj = null;
		try {
			userRollObj = userRollRepository.save(userRoll);
		}catch (DataIntegrityViolationException e) {
			logger.error("Record not saved, somthing went wrong please contact to support "+e.getMessage());
			throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
		}
		return userRollObj;
	}

}
