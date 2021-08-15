package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Playlist;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlaylistRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Playlist playlist) {
        entityManager.persist(playlist);
        return playlist.getPlaylistId();
    }

    public Playlist retrieve(Long playlistId) {
        Playlist playlist = entityManager.find(Playlist.class, playlistId);
        return playlist;
    }

    public Playlist update(Playlist playlist) {
        entityManager.merge(playlist);
        return playlist;
    }

    public void delete(Long playlistId) {
        Playlist playlist = entityManager.find(Playlist.class, playlistId);
        entityManager.remove(playlist);

    }
}


