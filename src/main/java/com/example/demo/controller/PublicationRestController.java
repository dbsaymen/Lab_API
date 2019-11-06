package com.example.demo.controller;

import com.example.demo.entity.Publication;
import com.example.demo.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/pulication")
public class PublicationRestController {
    @Autowired
    IPublicationService publicationService;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Publication> findAllPuvlications(){
        return publicationService.findAllPub();
    }
}
