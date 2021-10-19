package com.Nathan.springboottutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class PlayListAPIDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class Response extends CommonResponseDto {
        private List<SongDto> playlist;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class SongDto {
        private String title;
        private String url;
    }
}
