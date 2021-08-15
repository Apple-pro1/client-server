package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Emotion;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmotionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Emotion emotion) {
        entityManager.persist(emotion);
        return emotion.getEmotionId();
    }

    public Emotion retrieve(Long emotionId) {
        Emotion emotion = entityManager.find(Emotion.class, emotionId);
        return emotion;
    }

    public Emotion update(Emotion emotion) {
        entityManager.merge(emotion);
        return emotion;
    }

    public void delete(Long emotionId) {
        Emotion emotion = entityManager.find(Emotion.class, emotionId);
        entityManager.remove(emotion);

    }
}


