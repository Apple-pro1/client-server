package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ServiceMemberRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(ServiceMember serviceMember) {
        entityManager.persist(serviceMember);
        return serviceMember.getId();
    }

    public ServiceMember retrieve(Long serviceMemberId) {
        ServiceMember serviceMember = entityManager.find(ServiceMember.class, serviceMemberId);
        return serviceMember;
    }

    public Member update(Member serviceMember) {
        entityManager.merge(serviceMember);
        return serviceMember;
    }

    public void delete(Long serviceMemberId) {
        ServiceMember serviceMember = entityManager.find(ServiceMember.class, serviceMemberId);
        entityManager.remove(serviceMember);

    }
}


