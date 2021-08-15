package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.MemberPlaylist;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberPlaylistRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(MemberPlaylist memberPlaylist) {
        entityManager.persist(memberPlaylist);
        return memberPlaylist.getMemberPlaylistId();
    }

    public MemberPlaylist retrieve(Long memberPlaylistId) {
        MemberPlaylist memberPlaylist = entityManager.find(MemberPlaylist.class, memberPlaylistId);
        return memberPlaylist;
    }

    public MemberPlaylist update(MemberPlaylist memberPlaylist) {
        entityManager.merge(memberPlaylist);
        return memberPlaylist;
    }

    public void delete(Long memberPlaylistId) {
        MemberPlaylist memberPlaylist = entityManager.find(MemberPlaylist.class, memberPlaylistId);
        entityManager.remove(memberPlaylist);

    }
}


