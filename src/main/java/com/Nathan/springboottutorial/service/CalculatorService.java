package com.Nathan.springboottutorial.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b) {
        return a + b;
    }
    public double sub(double a, double b) {
        return a - b;
    }
    public double mult(double a, double b) {
        return a * b;
    }
    public double div(double a, double b) {
        return a / b;
    }
}
