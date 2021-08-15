package com.Nathan.springboottutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AddDto {
    @Getter @Setter
    public static class Request {
        private int a;
        private int b;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response {
        private int result;
    }
}
