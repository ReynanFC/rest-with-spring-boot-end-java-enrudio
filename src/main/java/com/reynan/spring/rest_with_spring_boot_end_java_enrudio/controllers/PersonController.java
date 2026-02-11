package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.controllers;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.data.dto.PersonDTO;
import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return personService.update(personDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
         personService.delete(id);
         return ResponseEntity.notFound().build();
    }

}
