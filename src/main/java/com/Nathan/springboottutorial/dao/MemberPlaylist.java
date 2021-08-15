package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_playlist")
@Getter @Setter
public class MemberPlaylist {
    @Id @GeneratedValue
    @Column(name = "member_playlist_id")
    private Long memberPlaylistId;

//    @Column(name = "member_id")
//    private String memberId;

    @ManyToOne
    @JoinColumn(name = "service_member_id")
    private ServiceMember serviceMember;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

}
