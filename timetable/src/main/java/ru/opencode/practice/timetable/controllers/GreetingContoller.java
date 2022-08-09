package ru.opencode.practice.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.opencode.practice.timetable.model.helpers.HumanNeeds;
import ru.opencode.practice.timetable.model.helpers.PersonTicketView;
import ru.opencode.practice.timetable.model.helpers.TicketBookingData;
import ru.opencode.practice.timetable.service.AdmineService;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;


@Controller
@RequestMapping("/api/view")
public class GreetingContoller  {
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
    public ResponseEntity<String> test(@PathVariable int id) {
       PersonTicketView a = personTicketViews.get(id);
       List<TicketBookingData> dataList = a.getTickets();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<Object>(dataList, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/booking", HttpMethod.POST, entity, String.class);

       return responseEntity;
    }
}