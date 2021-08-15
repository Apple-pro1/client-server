package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.dto.MemberDto;
import com.Nathan.springboottutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/member")
    public MemberDto.Response createMember(@RequestBody MemberDto.Request request) {
        return memberService.createMember(request);
    }

    @GetMapping(path = "/member/{memberId}")
    public MemberDto.Response getMember(@PathVariable Long memberId) { return memberService.getMember(memberId); }

    @DeleteMapping(path = "/member/{memberId}")
    public MemberDto.Response deleteMember(@PathVariable Long memberId) { return memberService.deleteMember(memberId); }
}
