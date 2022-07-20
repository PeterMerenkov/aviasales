package ru.opencode.practice.timetable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingContoller {
    @GetMapping
    public String hello(){
        return "";
    }
}
