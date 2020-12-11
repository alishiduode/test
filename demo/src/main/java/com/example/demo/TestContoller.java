package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {

    @RequestMapping("/xixi")
    public String xixi(){
        return "哈喽希希";
    }

}
