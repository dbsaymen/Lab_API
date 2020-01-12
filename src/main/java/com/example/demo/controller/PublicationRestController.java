package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Publication;
import com.example.demo.services.IPublicationService;

@RestController
@RequestMapping(value = "/publication")
@CrossOrigin
public class PublicationRestController {
    @Autowired
    IPublicationService publicationService;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Publication> findAllPuvlications(){
        return publicationService.findAllPub();
    }
}
