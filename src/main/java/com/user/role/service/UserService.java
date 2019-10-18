package com.user.role.service;

import java.util.List;

import com.user.role.model.User;

public interface UserService {

	User signUp(User user);

	User signIn(User user);

	List<User> getUsersByAuthType(String authType);

	List<User> getUserByName(String userName);

	User approveUser(Integer userId);

	User approveUserRequest(Integer userId, boolean isApprove);

	List<User> getUsersRequest();
}
