package ru.opencode.practice.timetable.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.opencode.practice.timetable.model.helpers.HumanNeeds;
import ru.opencode.practice.timetable.service.AdmineService;

@Controller
@RequestMapping("/api/view")
public class GreetingContoller {
    @Autowired
    AdmineService admineService;

    @RequestMapping("searchGet")
    public String searchGet() {
        return  "search";
    }

    @PostMapping
    @RequestMapping("/getFlights")
    public String takeFlights(@RequestBody HumanNeeds info, Model model,@PathVariable Test test) {
        model.addAttribute("personTicketView", admineService.takeFlights(info.arrival_city(), info.departure_city(), info.fare_conditions(), info.amount(), info.skip()));
        model.addAttribute("amount",info.amount());
        model.addAttribute("1",1);
        model.addAttribute("test",test);
        System.out.printf("TESTINGGGGGGGGGGGGGGGGGGGGGGG\nTESTINGGGGGGGGGGGGGGGGG");
        return  "search";
    }

}
@Data
class Test{
    private String test;

}
