package com.example.teamle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class TestController {

    @GetMapping(path = "/get-test")
    public String Test(){
        return "test";
    }
}