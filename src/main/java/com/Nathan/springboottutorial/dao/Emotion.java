package com.Nathan.springboottutorial.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emotion")
@Getter @Setter
@Builder
public class Emotion {
    @Id @GeneratedValue
    @Column(name = "emotion_id")
    private Long emotionId;



    @Column(name = "emotion_type")
    private String emotionType;

    @OneToMany(mappedBy = "emotion")
    private List<EmotionPlaylist> emotionPlaylists;

}
