package ru.opencode.practice.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.opencode.practice.timetable.model.helpers.HumanNeeds;
import ru.opencode.practice.timetable.service.AdmineService;

@Controller
@RequestMapping("/api/view")
public class GreetingContoller {
    @Autowired
    AdmineService admineService;
    @RequestMapping("search")
    public String search(){
        return "search.html";
    }

    @PostMapping
    @RequestMapping("/getFlights")
    public String takeFlights(@RequestBody HumanNeeds info, Model model) {
        model.addAttribute("personTicketView", admineService.takeFlights(info.arrival_city(), info.departure_city(), info.fare_conditions(), info.amount(), info.skip()));
        return "search.html";
    }
}
