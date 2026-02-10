package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.services;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.exception.ResourceNotFoundException;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.model.Person;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository  personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        logger.info("Finding person with id: " + id);

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");

       return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating a person");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }

    public List<Person> findAll() {
        logger.info("Finding all people");

        return personRepository.findAll();
    }

}
