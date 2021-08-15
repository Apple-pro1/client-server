package com.Nathan.springboottutorial.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class PageController {
//    @RequestMapping("/rest-test")
//    public String home() {
//        log.info("rest-test page");
//        return "restapitest";
//    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/sign-up")
    public String signUp() {
        log.info("sing-up page");
        return "signup";
    }
    @RequestMapping("/sign-in")
    public String signIn() {
        log.info("sing-in page");
        return "signin";
    }
}
