package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Playlist;
import com.Nathan.springboottutorial.dao.Playlist;
import com.Nathan.springboottutorial.dao.Song;
import com.Nathan.springboottutorial.dto.SongIdList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlaylistRepositoryTest {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveAndFindTest() throws JsonProcessingException {
        Playlist playlist = Playlist.builder()
                .songIds("1,2")
                .build();

        Long playlistId = playlistRepository.create(playlist);
        Playlist playlistRetrieved = playlistRepository.retrieve(playlistId);


        assertThat(playlistRetrieved).isNotNull();
        String retrievedSongsId = playlistRetrieved.getSongIds();
        ObjectMapper objectMapper = new ObjectMapper();
        SongIdList songIdsList = objectMapper.readValue(retrievedSongsId, SongIdList.class);
        int size = songIdsList.getSongIdList().size();
        assertThat(size).isEqualTo(6);
    }
}


