package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewMemberRepository extends JpaRepository<ServiceMember, Long> {
    ServiceMember findByMemberEmail(String memberEmail);
}
