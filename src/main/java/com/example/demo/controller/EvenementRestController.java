package com.example.demo.controller;

import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Evenement;
import com.example.demo.entity.Publication;
import com.example.demo.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/evenement")
public class EvenementRestController {
    @Autowired
    IEventService eventService;

    @GetMapping(value = "/all")
    public List<Evenement> findAllEvents() {
        return eventService.findAll();
    }

    @GetMapping(value = "/search/findByDateBetween/{startDate}/{endDate}")
    public List<Evenement> findByDateBetween(
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) throws Exception {
        try {
            Date startdate=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date enddate=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            return eventService.findEvenementByDateBetween(startdate,enddate);
        } catch (ParseException e) {
            throw new Exception("Invalid Date Format, Date Format should be like: dd-mm-yyyy");
        }
    }

    @GetMapping(value = "/{id}")
    public List<Evenement> findAllEvents(@PathVariable("id") String id) {
        Long Id = Long.parseLong(id);

        return eventService.findEvenementById(Id);
    }

    @PostMapping(value = "/")
    public Evenement addEvent(@RequestBody Evenement e) {
        return this.eventService.addEvenement(e);
    }

    @PutMapping(value = "/{id}")
    public Evenement updateEvent(@PathVariable("id") Long id, @RequestBody Evenement e) {
        e.setId(id);
        return this.eventService.updateEvenement(e);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEvent(@PathVariable("id") Long id, @RequestBody Evenement e) {
        this.eventService.deleteEvenement(id);
    }
}
