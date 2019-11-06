package com.example.demo.controller;

import com.example.demo.entity.Evenement;
import com.example.demo.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/evenement")
public class EvenementRestController {
    @Autowired
    IEventService eventService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public List<Evenement> findAllEvents(){
        return eventService.findAll();
    }
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Evenement> findAllEvents(@PathVariable("id") String id){
        Long Id=Long.parseLong(id);
        return eventService.findEvenementById(Id);
    }
}
