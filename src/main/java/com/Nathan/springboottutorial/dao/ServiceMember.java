package com.Nathan.springboottutorial.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@Table(name = "service_member")
@NoArgsConstructor @AllArgsConstructor
public class ServiceMember {
    @Id @GeneratedValue
    @Column(name = "service_member_id")
    private Long id;
    @Column(name = "service_member_email")
    private String memberEmail;
    @Column(name = "service_member_password")
    private String memberPassword;
    @OneToMany(mappedBy = "serviceMember")
    private List<MemberEmotion> memberEmotionList = new ArrayList<>();

    @OneToMany(mappedBy = "serviceMember")
    private List<MemberPlaylist> memberPlaylists = new ArrayList<>();

    public ServiceMember(String memberEmail, String memberPassword) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
    }
}
