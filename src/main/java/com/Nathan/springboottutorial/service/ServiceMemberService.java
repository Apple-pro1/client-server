package com.Nathan.springboottutorial.service;

import com.Nathan.springboottutorial.controller.SessionStore;
import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dao.ServiceMember;
import com.Nathan.springboottutorial.dto.LoginDto;
import com.Nathan.springboottutorial.dto.MemberDto;
import com.Nathan.springboottutorial.dto.ServiceMemberDto;
import com.Nathan.springboottutorial.repository.MemberRepository;
import com.Nathan.springboottutorial.repository.NewMemberRepository;
import com.Nathan.springboottutorial.repository.ServiceMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceMemberService {
    @Autowired
    private ServiceMemberRepository serviceMemberRepository;

    @Autowired
    private NewMemberRepository newMemberRepository;

    @Autowired
    private SessionStore sessionStore;

    public String createSession(LoginDto.Request request) {
        return sessionStore.insertSession(new ServiceMember(request.getMemberEmail(), request.getMemberPassword()));

    }


    @Transactional
    public ServiceMemberDto.Response createMember(ServiceMemberDto.Request serviceMemberDto) {
        ServiceMember serviceMember = convert(serviceMemberDto);
        Long createdMemberId = serviceMemberRepository.create(serviceMember);
        return convert(createdMemberId, serviceMember);
    }

    private ServiceMemberDto.Response convert(Long createdMemberId, ServiceMember serviceMember) {
        ServiceMemberDto.Response response = new ServiceMemberDto.Response(createdMemberId,serviceMember.getMemberEmail());
        return response;
    }


    private ServiceMember convert(ServiceMemberDto.Request serviceMemberDto) {
        ServiceMember serviceMember = new ServiceMember();
        serviceMember.setMemberEmail(serviceMemberDto.getMemberEmail());
        serviceMember.setMemberPassword(serviceMemberDto.getMemberPassword());
        return serviceMember;
    }

    public ServiceMember findMemberByMemberEmail(String memberEmail) {
        ServiceMember serviceMember = newMemberRepository.findByMemberEmail(memberEmail);
        return serviceMember;
    }
}
