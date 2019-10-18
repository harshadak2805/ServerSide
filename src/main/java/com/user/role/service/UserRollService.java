package com.user.role.service;

import java.util.List;

import com.user.role.model.UserRoll;

public interface UserRollService {

	List<UserRoll> getAllUserRoll();

	UserRoll createRole(UserRoll userRoll);
}
