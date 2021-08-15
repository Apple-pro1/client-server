package com.Nathan.springboottutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
public class SongIdList {
    private List<Integer> songIdList;
}
