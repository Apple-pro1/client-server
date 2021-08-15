package com.Nathan.springboottutorial.controller;

import com.Nathan.springboottutorial.dto.HelloRequest;
import com.Nathan.springboottutorial.dto.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
//    @GetMapping(path = "/")
//    public String hello(){
//        return "Hello world";
//    }

    @GetMapping(path = "/hello2")
    public String hello2() {
        return "hello2";
    }

    @GetMapping(path = "/hello3/{n}")
    public String hello3(@PathVariable int n) {
        return "hello!! " + n;
    }

    @GetMapping(path = "/hello4")
    public String hello4(@RequestParam int a, @RequestParam int b, @RequestParam String c) {
        return c + "|" + b + "|" + a;
    }

    @PostMapping(path = "/hello")
    public String helloPost(@RequestBody HelloRequest helloRequest) {
        return "hello " + helloRequest.name + " in" + helloRequest.country + "!";
    }

    @PostMapping(path = "/hello2")
    public HelloResponse helloPost2(@RequestBody HelloRequest helloRequest) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.version = 1;
        helloResponse.greeting = "hello " + helloRequest.name + " in" + helloRequest.country + "!";
        return helloResponse;
    }
}

