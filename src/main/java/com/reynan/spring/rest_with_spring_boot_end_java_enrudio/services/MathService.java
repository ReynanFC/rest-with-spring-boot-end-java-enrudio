package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.services;

import org.springframework.stereotype.Service;


@Service
public class MathService {

    public Double sum(Double n1, Double n2) {
        return n1 + n2;
    }

    public Double subtraction(Double n1, Double n2) {
        return n1 - n2;
    }

    public Double division(Double n1, Double n2) {

        if (n2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return n1 / n2;
    }

    public Double average(Double n1, Double n2) {
        return (n1 + n2) / 2;
    }

    public Double squareRoot(Double number) {

        if (number < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }

        return Math.sqrt(number);
    }
}

