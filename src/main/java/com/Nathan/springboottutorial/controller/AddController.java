package com.Nathan.springboottutorial.controller;


import com.Nathan.springboottutorial.dto.AddDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
    @PostMapping(path = "/add")
    public AddDto.Response countUp(@RequestBody AddDto.Request request) {
        return new AddDto.Response(request.getA() + request.getB());
    }
}
