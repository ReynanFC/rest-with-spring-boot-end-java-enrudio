package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class TesLogController {

    private final AtomicLong counter = new AtomicLong();
    private Logger  logger = LoggerFactory.getLogger(TesLogController.class);

    @GetMapping("/test")
    public String testLog() {

        logger.info("This is an INFO log");
        logger.warn("This is an WARN log");
        logger.debug("This is an DEBUG log");
        logger.trace("This is an TRACE log");
        logger.error("This is an ERROR log");

        return "Logs generated successfully";
    }
}
