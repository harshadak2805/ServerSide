package com.user.role.service.impl;

import ch.qos.logback.classic.Logger;
import com.user.role.custom.exception.RecordNotFoundException;
import com.user.role.model.Person;
import com.user.role.repository.PersonRepository;
import com.user.role.service.PersonService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    private static final ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
    private static final String NO_RECORD_FOUND_MSG = "No record found in database";

    @Override
    public List<Person> getAllPersons() {
        List<Person> perosnsLIst =  (List<Person>) personRepository.findAll();
        if(perosnsLIst.isEmpty()){
            logger.error(NO_RECORD_FOUND_MSG);
            throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
        }else{
            return perosnsLIst;
        }
    }

    @Override
    public Person registerPersons(Person persons) {
        logger.info("register person");
        Person personObj=null;
        try{
            personObj= personRepository.save(persons);
        }catch (DataIntegrityViolationException e){
            logger.error("Record not saved, somthing went wrong please contact to support "+e.getMessage());
            throw new RecordNotFoundException(NO_RECORD_FOUND_MSG);
        }
        return personObj;
    }
}
