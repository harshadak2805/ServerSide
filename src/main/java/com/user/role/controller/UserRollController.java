package com.user.role.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.role.model.User;
import com.user.role.model.UserRoll;
import com.user.role.service.UserRollService;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @author Laxman.Nikam
 * userRoll Controller
 */
@RestController
@RequestMapping(value = "/userRoll")
public class UserRollController {
	
	@Autowired
	UserRollService userRollService;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserRollController.class);
	
	/**
	 * 
	 * @author Laxman.Nikam
	 * @throws RecordNotFoundException
	 * @return UserRoll List Details
	 */
	@GetMapping("/getAllUserRoll")
	public ResponseEntity<List<UserRoll>> getAllUserRoll() {
		logger.info("getAllUserRoll API called");
			return new ResponseEntity<List<UserRoll>>(userRollService.getAllUserRoll(), new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * 
	 * @author Laxman.Nikam
	 * @param userRoll
	 * @throws RecordNotFoundException
	 * @return
	 */
	
	@PostMapping("/createRole")
	public ResponseEntity<UserRoll> createRole(@RequestBody UserRoll userRoll) {
		logger.info("crate Role API called");
		return new ResponseEntity<UserRoll>(userRollService.createRole(userRoll), new HttpHeaders(), HttpStatus.OK);
	}
	
}

