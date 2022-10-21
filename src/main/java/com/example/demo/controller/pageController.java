package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
    @GetMapping("/join")
    public String joinPage(){
        return "join";
    }
    @GetMapping("/login")
    public String loginPage(){ return "login"; }
    @GetMapping("/modify")
    public String modifyPage(){ return "modify";}
    @GetMapping("/cinput")
    public String cinputPage(){ return "class_input";}

}
