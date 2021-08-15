package com.Nathan.springboottutorial.service;

import com.Nathan.springboottutorial.dao.Member;
import com.Nathan.springboottutorial.dto.MemberDto;
import com.Nathan.springboottutorial.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public MemberDto.Response createMember(MemberDto.Request memberDto) {
        Member member = convert(memberDto);
        Long createdMemberId = memberRepository.create(member);
        return convert(createdMemberId, memberDto);
    }

    public MemberDto.Response getMember(Long memberId) {
        Member member = memberRepository.retrieve(memberId);
        if (member == null) {
            MemberDto.Response response = createGetMemberFailResponse();
            return response;
        }
        MemberDto.Response response = convert(member);
        return response;
    }


    @Transactional
    public MemberDto.Response deleteMember(Long memberId) {
        try {
            memberRepository.delete(memberId);
        } catch (Exception e) {
            MemberDto.Response response = createDeleteFailResponse();
            return response;
        }
        MemberDto.Response response = new MemberDto.Response(memberId, null);
        return response;
    }

    private Member convert(MemberDto.Request memberDto) {
        Member member = new Member();
        member.setMemberName(memberDto.getMemberEmail());
        return member;
    }

    private MemberDto.Response convert(Long createdMemberId, MemberDto.Request memberDto) {
        MemberDto.Response response = new MemberDto.Response();
        response.setMemberId(createdMemberId);
        response.setMemberEmail(memberDto.getMemberEmail());
        return response;
    }

    private MemberDto.Response createGetMemberFailResponse() {
        MemberDto.Response response = new MemberDto.Response(null, null);
        response.setResponseCode(20);
        response.setResponseMessage("no member in db");
        return response;
    }

    private MemberDto.Response createDeleteFailResponse() {
        MemberDto.Response response = new MemberDto.Response(null, null);
        response.setResponseCode(20);
        response.setResponseMessage("delete failed.no member in db.");
        return response;
    }

    private MemberDto.Response convert(Member member) {
        MemberDto.Response response = new MemberDto.Response();
        response.setMemberId(member.getId());
        response.setMemberEmail(member.getMemberName());
        return response;
    }
}
