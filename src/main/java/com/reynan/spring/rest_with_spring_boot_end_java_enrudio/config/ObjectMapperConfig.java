package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;


@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper ObjectMapper() {
        // ObjectMapper of databind
        ObjectMapper mapper = new ObjectMapper();

        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("PersonFilter",
                        SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));

        mapper.setFilterProvider(filters);
        return mapper;
    }
}
