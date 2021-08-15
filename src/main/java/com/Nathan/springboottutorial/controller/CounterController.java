package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.dto.CountUpDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    private static int count = 1;

    @GetMapping(path = "/count-up")
    public CountUpDto countUp() {
        count++;
        return new CountUpDto(count);
    }
}
