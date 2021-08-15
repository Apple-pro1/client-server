package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Member member) {
        entityManager.persist(member);
        return member.getId();
    }

    public Member retrieve(Long memberId) {
        Member member = entityManager.find(Member.class, memberId);
        return member;
    }

    public Member update(Member member) {
        entityManager.merge(member);
        return member;
    }

    public void delete(Long memberId) {
        Member member = entityManager.find(Member.class, memberId);
        entityManager.remove(member);

    }
}


