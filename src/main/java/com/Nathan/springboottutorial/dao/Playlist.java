package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
@Getter @Setter
public class Playlist {
    @Id
    @GeneratedValue
    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "songs_id")
    private String songsId;

    @Column(name = "playlist_title")
    private String playlistTitle;
}

