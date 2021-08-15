package com.Nathan.springboottutorial.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "song")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Song {
    @Id @GeneratedValue
    @Column(name = "song_id")
    private Long songId;

    @Column(name = "song_title")
    private String songTitle;

    @Column(name = "song_url")
    private String songURL;

}
