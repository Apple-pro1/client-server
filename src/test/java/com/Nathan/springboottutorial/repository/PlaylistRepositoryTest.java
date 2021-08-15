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
        Playlist playlist = new Playlist();
        playlist.setPlaylistTitle("default");
        playlist.setSongsId("{\n" +
                "   \"songIdList\":[\n" +
                "      1,\n" +
                "      2,\n" +
                "      3,\n" +
                "      4,\n" +
                "      5,\n" +
                "      6\n" +
                "   ]\n" +
                "}");

        Long playlistId = playlistRepository.create(playlist);
        Playlist playlistRetrieved = playlistRepository.retrieve(playlistId);


        assertThat(playlistRetrieved).isNotNull();
        assertThat(playlistRetrieved.getPlaylistTitle())
                .isEqualTo("default");
        String retrievedSongsId = playlistRetrieved.getSongsId();
        ObjectMapper objectMapper = new ObjectMapper();
        SongIdList songIdList = objectMapper.readValue(retrievedSongsId, SongIdList.class);
        int size = songIdList.getSongIdList().size();
        assertThat(size).isEqualTo(6);
    }
}


