package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.repository;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
