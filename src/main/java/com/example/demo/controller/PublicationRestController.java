package com.example.demo.controller;

import com.example.demo.entity.Publication;
import com.example.demo.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/publication")
@CrossOrigin
public class PublicationRestController {
    @Autowired
    IPublicationService publicationService;

    @GetMapping(value="/all")
    public List<Publication> findAllPuvlications(){
        return publicationService.findAllPub();
    }
    @GetMapping(value="/search/findByDateBetween/{startDate}/{endDate}")
    public List<Publication> findByDateBetween(@PathVariable("startDate") String startDate,
                                               @PathVariable("endDate") String endDate) throws Exception {
        try {
            Date startdate = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date enddate = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            return publicationService.findPubByDateBetween(startdate, enddate);
        } catch (ParseException e) {
            throw new Exception("Invalid Date Format, Date Format should be like: dd-mm-yyyy");
        }
    }
}
