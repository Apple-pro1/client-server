package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Song;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SongRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Song song) {
        entityManager.persist(song);
        return song.getSongId();
    }

    public Song retrieve(Long songId) {
        Song song = entityManager.find(Song.class, songId);
        return song;
    }

    public Song update(Song song) {
        entityManager.merge(song);
        return song;
    }

    public void delete(Long songId) {
        Song song = entityManager.find(Song.class, songId);
        entityManager.remove(song);

    }
}


