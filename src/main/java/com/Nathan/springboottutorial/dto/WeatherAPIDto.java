package com.Nathan.springboottutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class WeatherAPIDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class Response extends CommonResponseDto {
        private String weatherTypeString;
        private Double temperature;
    }
}
