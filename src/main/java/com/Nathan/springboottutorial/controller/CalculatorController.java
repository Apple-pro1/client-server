package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(path = "/add/{number1}/{number2}")
    public String add(@PathVariable double number1, @PathVariable double number2) {
        return String.valueOf(calculatorService.add(number1, number2));
    }


    @GetMapping(path = "/sub/{number1}/{number2}")
    public String sub(@PathVariable double number1, @PathVariable double number2) {
        return String.valueOf(calculatorService.sub(number1, number2));
        }


    @GetMapping(path = "/mult/{number1}/{number2}")
    public String mult(@PathVariable double number1, @PathVariable double number2) {
        return String.valueOf(calculatorService.mult(number1, number2));
    }

    @GetMapping(path = "/div/{number1}/{number2}")
    public String div(@PathVariable double number1, @PathVariable double number2) {
        return String.valueOf(calculatorService.div(number1, number2));
    }
}
