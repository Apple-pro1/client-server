package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "emotion_playlist")
@Getter @Setter
public class EmotionPlaylist {
    @Id @GeneratedValue
    @Column(name = "emotion_playlist_id")
    private Long emotionPlaylistId;

//    @Column(name = "emotion_id")
//    private String emotionId;
    @ManyToOne
    @JoinColumn(name = "emotion_id")
    private Emotion emotion;

//    @Column(name = "playlist_id")
//    private String playlistId;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

}
