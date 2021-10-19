package com.Nathan.springboottutorial.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
@Getter @Setter
@Builder
public class Playlist {
    @Id
    @GeneratedValue
    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "song_ids")
    private String songIds;
}

