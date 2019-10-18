package com.user.role.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.role.model.UserRoll;

@Repository
public interface UserRollRepository extends CrudRepository<UserRoll, Integer>{

}
