package com.Nathan.springboottutorial;

import com.Nathan.springboottutorial.component.WeatherAPIClient;
import com.Nathan.springboottutorial.dto.WeatherDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.sql.SQLOutput;

public class OpenAPITest {
    @SneakyThrows
    public static void main(String[] args) {
        // TODO add codes to call open api
        WeatherAPIClient weatherAPIClient = new WeatherAPIClient();
        String jsonString = weatherAPIClient.getWeatherInfoJson();
        System.out.println("jsonString = " + jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherDto weatherDto = objectMapper.readValue(jsonString, WeatherDto.class);
        String resultMsg = weatherDto.getResponse().getHeader().getResultMsg();
        System.out.println(resultMsg);
        System.out.println(weatherDto.getTemperature());
        System.out.println(weatherDto.getWeatherType());
    }
}
