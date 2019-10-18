package com.user.role.repository;

import com.user.role.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Integer> {

//    @Async
//    @Query(value = "SELECT * FROM person WHERE authorize = :authorize ", nativeQuery = true)
//    List<Person> getPersonByUser(@Param("authorize") String authorize);
}
