package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_emotion")
@Getter @Setter
public class MemberEmotion {
    @Id @GeneratedValue
    @Column(name = "member_emotion_id")
    private Long memberEmotionId;

//    @Column(name = "member_id")
  //  private String memberId;

    @ManyToOne
    @JoinColumn(name = "service_member_id")
    private ServiceMember serviceMember;

    @ManyToOne
    @JoinColumn(name = "emotion_id")
    private Emotion emotion;

}
