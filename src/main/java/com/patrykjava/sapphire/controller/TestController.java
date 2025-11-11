package com.patrykjava.sapphire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test/user")
    public String userAccess() {
        return "Hello User or Admin!";
    }

    @GetMapping("/api/test/admin")
    public String adminAccess() {
        return "Hello Admin!";
    }
}
