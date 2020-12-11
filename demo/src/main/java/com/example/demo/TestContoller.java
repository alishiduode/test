package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestContoller {

    @RequestMapping("/xixi")
    public String xixi(Model model){
        return "test.html";
    }

    @RequestMapping("/lili")
    public String lili(){
        return "晚上加班到几点";
    }
}
