package com.Nathan.springboottutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LoginDto {
    @Getter @Setter
    public static class Request {
        private String memberEmail;
        private String memberPassword;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response {
        private boolean isSuccess;
        private String sessionId;
    }
}
