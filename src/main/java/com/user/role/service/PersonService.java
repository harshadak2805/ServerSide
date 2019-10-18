package com.user.role.service;

import com.user.role.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person registerPersons(Person persons);
}
