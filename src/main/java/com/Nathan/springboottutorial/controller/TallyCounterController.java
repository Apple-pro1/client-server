package com.Nathan.springboottutorial.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TallyCounterController {
    private int count = 0;

    @GetMapping(path = "count")
    public String getCount() {
        return String.valueOf(this.count);
    }

    @PostMapping(path = "/count/{increment}")
    public String incrementBy(@PathVariable int increment) {
        this.count += increment;
        return String.valueOf(this.count);
    }

    @PutMapping(path = "/count")
    public String incrementByOne() {
        this.count++;
        return String.valueOf(this.count);
    }

    @DeleteMapping(path = "/count")
    public String delete() {
        this.count = 0;
        return String.valueOf(this.count);
    }
}
