package ru.opencode.practice.timetable.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.opencode.practice.timetable.model.helpers.HumanNeeds;
import ru.opencode.practice.timetable.model.helpers.PersonTicketView;
import ru.opencode.practice.timetable.model.helpers.Test;
import ru.opencode.practice.timetable.model.helpers.TicketBookingData;
import ru.opencode.practice.timetable.service.AdmineService;

import java.lang.reflect.Array;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/api/view")
public class GreetingContoller {
    @Autowired
    AdmineService admineService;

    private HttpClient client;

    List<PersonTicketView> personTicketViews;

    @RequestMapping("searchGet")
    public String searchGet(Model model) {
        model.addAttribute("info", new HumanNeeds());
        return "search.html";
    }

    @PostMapping
    @RequestMapping("getFlights")
    public String takeFlights(@ModelAttribute HumanNeeds info, Model model) {
        personTicketViews = admineService.takeFlights(info.getArrival_city(), info.getDeparture_city(), info.getFare_conditions(), info.getAmount(), info.getSkip());
        model.addAttribute("info", info);
        model.addAttribute("personTicketView", personTicketViews);


        return "search.html";
    }

    @PostMapping
    @RequestMapping("test/{id}")
    public String test(@PathVariable int id) {
       PersonTicketView a = personTicketViews.get(id);
       List<TicketBookingData> b = a.getTickets();

       
        System.out.println("Я тут");
        return ("booking");
    }
}