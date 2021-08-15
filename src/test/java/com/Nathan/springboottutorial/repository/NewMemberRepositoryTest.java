package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.ServiceMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NewMemberRepositoryTest {
    @Autowired
    NewMemberRepository newMemberRepository;

    @Test
    @Transactional
    void saveAndFindTest() {
        ServiceMember serviceMember = new ServiceMember();
        serviceMember.setMemberEmail("aaa@gmail.com");
        serviceMember.setMemberPassword("aaaa");

      ServiceMember savedServiceMember = newMemberRepository.save(serviceMember);

      ServiceMember byMemberEmail = newMemberRepository.findByMemberEmail("aaa@gmail.com");

      assertThat(byMemberEmail.getMemberEmail())
              .isEqualTo("aaa@gmail.com");
      assertThat(byMemberEmail.getMemberPassword())
              .isEqualTo("aaaa");
    }

    @Test
    void find() {
    }
}