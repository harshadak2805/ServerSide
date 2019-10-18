package com.user.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.user.role.model.User;

import javax.annotation.security.PermitAll;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Async
	@Query(value = "SELECT * FROM users WHERE LOWER(user_name) = LOWER(:userName) and password = :password and authorize = 'Y'", nativeQuery = true)
	User signIn(@Param("userName") String userName, @Param("password") String password);

	@Async
	@Query(value = "SELECT * FROM users WHERE authorize = :authorize ", nativeQuery = true)
	List<User> getUsersByAuthType(@Param("authorize") String authorize);

    @Async
    @Query(value = "SELECT * FROM users WHERE user_name = :userName ", nativeQuery = true)
    List<User> getUsersByName(@Param("userName") String userName);

    @Async
	@Query(value = " SELECT * from users where authorize = :authorize  and approveuser= :approveUser ", nativeQuery=true)
	List<User> getUsersRequest(@Param("authorize") String authorize, @Param("approveUser") boolean approveUser);

}
