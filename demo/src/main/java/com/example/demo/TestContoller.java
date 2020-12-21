package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

@Controller
public class TestContoller {

    @RequestMapping("/xixi")
    public String xixi(Model model){
        return "test.html";
    }

    @RequestMapping("/lili")
    public String lili(){
        return "test2.html";
    }

}
