package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.EmotionPlaylist;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmotionPlaylistRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(EmotionPlaylist emotionPlaylist) {
        entityManager.persist(emotionPlaylist);
        return emotionPlaylist.getEmotionPlaylistId();
    }

    public EmotionPlaylist retrieve(Long emotionPlaylistId) {
        EmotionPlaylist emotionPlaylist = entityManager.find(EmotionPlaylist.class, emotionPlaylistId);
        return emotionPlaylist;
    }

    public EmotionPlaylist update(EmotionPlaylist emotionPlaylist) {
        entityManager.merge(emotionPlaylist);
        return emotionPlaylist;
    }

    public void delete(Long emotionPlaylistId) {
        EmotionPlaylist emotionPlaylist = entityManager.find(EmotionPlaylist.class, emotionPlaylistId);
        entityManager.remove(emotionPlaylist);

    }
}


