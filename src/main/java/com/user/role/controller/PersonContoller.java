package com.user.role.controller;

import com.user.role.model.Person;
import com.user.role.service.PersonService;
import org.slf4j.Logger;
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

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonContoller {

    @Autowired
    PersonService personService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(PersonContoller.class);

    @PostMapping("/registerPerson")
    public ResponseEntity registerPerosn(@RequestBody Person person){
        return new ResponseEntity<Person>(personService.registerPersons(person), new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping("/getAllPerosn")
    public ResponseEntity<List<Person>> getAllPerosn(){
        return new ResponseEntity<List<Person>>(personService.getAllPersons(),new HttpHeaders(), HttpStatus.OK);
    }

}
