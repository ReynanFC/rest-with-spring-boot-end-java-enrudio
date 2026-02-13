package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.services;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.data.dto.v1.PersonDTO;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.data.dto.v2.PersonDTOV2;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.exception.ResourceNotFoundException;
import static com.reynan.spring.rest_with_spring_boot_end_java_enrudio.mapper.ObjectMapper.parseListObjects;
import static com.reynan.spring.rest_with_spring_boot_end_java_enrudio.mapper.ObjectMapper.parseObject;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.mapper.custom.PersonMapper;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.model.Person;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository  personRepository;

    @Autowired
    private PersonMapper converter;

    public PersonDTO findById(Long id) {
        logger.info("Finding person with id: " + id);

        var person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(person, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!");
        var entity = parseObject(personDTO, Person.class);

       return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 personDTO) {
        logger.info("Creating one Person V2!");

        var entity = converter.convertDTOToEntity(personDTO);

        return converter.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating a person");

        Person entity = personRepository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all people");

        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }
}
