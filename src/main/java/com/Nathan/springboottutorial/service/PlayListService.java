package com.Nathan.springboottutorial.service;

import com.Nathan.springboottutorial.dto.PlayListAPIDto;
import com.Nathan.springboottutorial.repository.PlaylistRepository;
import com.Nathan.springboottutorial.type.EmotionTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayListService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Transactional
    public PlayListAPIDto getPlayList(EmotionTypeEnum emotionTypeEnum) {
        switch (emotionTypeEnum) {
            case HAPPY:
                break;
            case SAD:
                break;
            case ANGRY:
                break;
            default:
                break;

        }

        return null;
    }
}
