package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.controllers;

import com.reynan.spring.rest_with_spring_boot_end_java_enrudio.services.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping( "/sum/{n1}/{n2}")
    public Double sum(@PathVariable Double n1,
                      @PathVariable Double n2) {
        return mathService.sum(n1, n2);
    }

    @RequestMapping("/subtraction/{n1}/{n2}")
    public Double subtraction(@PathVariable Double n1,
                              @PathVariable Double n2) {
        return mathService.subtraction(n1, n2);
    }

    @RequestMapping("/division/{n1}/{n2}")
    public Double division(@PathVariable Double n1,
                           @PathVariable Double n2) {
        return mathService.division(n1, n2);
    }

    @RequestMapping("/average/{n1}/{n2}")
    public Double average(@PathVariable Double n1,
                          @PathVariable Double n2) {
        return mathService.average(n1, n2);
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable Double number) {
        return mathService.squareRoot(number);
    }
}
