package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.component.WeatherAPIClient;
import com.Nathan.springboottutorial.dto.PlayListAPIDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayListController {
    @Autowired
    private WeatherAPIClient weatherAPIClient;

    @GetMapping(path = "/playlist")
    public PlayListAPIDto.Response getWeather(@PathVariable int emotionCode) {
        return null;
    }
}
