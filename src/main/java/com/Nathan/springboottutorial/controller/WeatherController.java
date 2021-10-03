package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.component.WeatherAPIClient;
import com.Nathan.springboottutorial.dto.WeatherAPIDto;
import com.Nathan.springboottutorial.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private WeatherAPIClient weatherAPIClient;

    @GetMapping(path = "/weather")
    public WeatherAPIDto.Response getWeather() {
        WeatherDto weatherDto = weatherAPIClient.getWeather();
        return convert(weatherDto);
    }

    private WeatherAPIDto.Response convert(WeatherDto weatherDto) {
        WeatherAPIDto.Response response = new WeatherAPIDto.Response();
        response.setResponseCode(0);
        response.setResponseMessage("Success");
        response.setTemperature(weatherDto.getTemperature());
        response.setWeatherTypeString(weatherDto.getWeatherType().name());
        return response;
    }
}
