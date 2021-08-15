package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.dao.ServiceMember;
import com.Nathan.springboottutorial.dto.LoginDto;
import com.Nathan.springboottutorial.dto.ServiceMemberDto;
import com.Nathan.springboottutorial.service.ServiceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceMemberController {
    @Autowired
    private ServiceMemberService serviceMemberService;



    @PostMapping(path = "/service-member")
    public ServiceMemberDto.Response createMember(@RequestBody ServiceMemberDto.Request request) {
        if (!validate(request.getMemberEmail(), request.getMemberPassword())) {
            ServiceMemberDto.Response response = new ServiceMemberDto.Response(null, null);
            response.setResponseCode(600);
            response.setResponseMessage("invalid user input");
            return response;
        }
        return serviceMemberService.createMember(request);
    }

    @PostMapping(path = "/login")
    public LoginDto.Response login(@RequestBody LoginDto.Request request) {
        // email, password check
        if (!validate(request.getMemberEmail(), request.getMemberPassword())) {
            return failResponse();
        }
        if (!checkEmailAndPassword(request.getMemberEmail(), request.getMemberPassword()) ) {
            return failResponse();
        }
        // create new sessionId
        String sessionId = serviceMemberService.createSession(request);
        // return response
        LoginDto.Response response = new LoginDto.Response(true, sessionId);
        return response;
    }


    private boolean validate(String memberEmail, String memberPassword) {
        if (StringUtils.isEmpty(memberEmail)) {
            return false;
        }
        if (StringUtils.isEmpty(memberPassword)) {
            return false;
        }
        return true;
    }

    private boolean checkEmailAndPassword(String memberEmail, String memberPassword) {
        ServiceMember serviceMember = serviceMemberService.findMemberByMemberEmail(memberEmail);
        if (serviceMember == null) {
            return false;
        }
        return serviceMember.getMemberPassword().equals(memberPassword);
    }


    private LoginDto.Response failResponse() {
        LoginDto.Response response = new LoginDto.Response(false, null);
                return response;
    }
}
