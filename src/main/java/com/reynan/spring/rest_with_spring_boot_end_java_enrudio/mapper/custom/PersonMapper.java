package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.mapper.custom;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.data.dto.v2.PersonDTOV2;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {


    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDate(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 personDTO) {
        Person person = new Person();

        person.setId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        // person.setBirthDate(new Date());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());

        return person;
    }
}
