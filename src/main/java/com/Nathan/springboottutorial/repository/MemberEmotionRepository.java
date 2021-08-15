package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.MemberEmotion;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberEmotionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(MemberEmotion memberEmotion) {
        entityManager.persist(memberEmotion);
        return memberEmotion.getMemberEmotionId();
    }

    public MemberEmotion retrieve(Long memberEmotionId) {
        MemberEmotion memberEmotion = entityManager.find(MemberEmotion.class, memberEmotionId);
        return memberEmotion;
    }

    public MemberEmotion update(MemberEmotion memberEmotion) {
        entityManager.merge(memberEmotion);
        return memberEmotion;
    }

    public void delete(Long memberEmotionId) {
        MemberEmotion memberEmotion = entityManager.find(MemberEmotion.class, memberEmotionId);
        entityManager.remove(memberEmotion);

    }
}


