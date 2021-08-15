package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.dao.ServiceMember;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
public class SessionStore {
    private Map<String, ServiceMember> sessionIdServiceMemberMap;

    public SessionStore() {
        sessionIdServiceMemberMap = new HashMap<>();
    }

    public String insertSession(ServiceMember serviceMember) {
        //create new session Id(UUID)
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        // <sessionId, serviceMember> - set
        sessionIdServiceMemberMap.put(uuidString, serviceMember);
        // return createdSessionId
        return uuidString;
    }
}
