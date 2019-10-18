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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.role.model.User;
import com.user.role.service.UserService;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @author Laxman.Nikam
 * User Controller
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 
	 * @author Laxman.Nikam
	 * @throws RecordNotFoundException
	 * @param user
	 * @return User
	 */
	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		logger.info("signUp API called");
		return new ResponseEntity<User>(userService.signUp(user), new HttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @author Laxman.Nikam
	 * @throws RecordNotFoundException
	 * @param user
	 * @return user
	 */
	@PostMapping("/signIn")
	public ResponseEntity<User> signIn(@RequestBody User user) {
		logger.info("signIp API called");
		logger.info("userinfo"+user.getUserName());
		logger.info("userinfo"+user.getPassword());
//		User userInfo = userService.signIn(user);
//		if(userInfo!=null){
//
//		}
		return new ResponseEntity<User>(userService.signIn(user), new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * 
	 * @author Laxman.Nikam
	 * @throws RecordNotFoundException
	 * @param authType
	 * @return User List
	 */
	@GetMapping("/getUsersByAuthType")
	public ResponseEntity<List<User>> getUsersByAuthType(@RequestParam(name = "authType") String authType) {
		logger.info("getAllUserRoll API called");
			return new ResponseEntity<List<User>>(userService.getUsersByAuthType(authType), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/searchByName")
	public ResponseEntity<List<User>> getUserByName(@RequestParam(name="userName") String userName){
		logger.info("search User");
		return new ResponseEntity<List<User>>(userService.getUserByName(userName),new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/approveUser")
	public ResponseEntity<User> approveUser(@RequestParam(name="userId") Integer userId){
		return new ResponseEntity<User>(userService.approveUser(userId),new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/approveUserRequest")
	public ResponseEntity<User> approveUserRequest(@RequestParam(name="userId") Integer userId,@RequestParam(name="isApprove") boolean isApprove){
		return new ResponseEntity<User>(userService.approveUserRequest(userId,isApprove),new HttpHeaders(), HttpStatus.OK);

	}


	@GetMapping("/getUsersRequest")
	public ResponseEntity<List<User>> getUsersRequest() {
		logger.info("getAllUserRoll API called");
		return new ResponseEntity<List<User>>(userService.getUsersRequest(), new HttpHeaders(), HttpStatus.OK);
	}


//	@PostMapping("/registerPerson")
//	public ResponseEntity<Person> registerPerson(@RequestBody Person person){
//		logger.info("register person called " );
//		return new ResponseEntity<Person>()
//	}
}
