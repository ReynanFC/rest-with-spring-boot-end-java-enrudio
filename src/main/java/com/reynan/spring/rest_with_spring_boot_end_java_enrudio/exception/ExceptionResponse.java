package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
