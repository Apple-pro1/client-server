package com.Nathan.springboottutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CommonResponseDto {
    private int responseCode;
    private String responseMessage;
}
