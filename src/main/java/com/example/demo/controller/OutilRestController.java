package com.example.demo.controller;

import com.example.demo.entity.Outil;
import com.example.demo.services.IOutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/outil")
public class OutilRestController {
    @Autowired
    IOutilService iOutilService;

    @GetMapping(value = "/")
    public List<Outil> getAllOutil(){
        return this.iOutilService.findAll();
    }
    @PostMapping(value = "/")
    public Outil addOutil(@RequestBody Outil outil){
        return this.iOutilService.addOutil(outil);
    }
    @PutMapping(value = "/{id}")
    public Outil updateOutil(@RequestBody Outil outil,@PathVariable("id") Long id){
        outil.setId(id);
        return this.iOutilService.updateOutil(outil);
    }
    @DeleteMapping(value = "/{id}")
    public void deletOutil(@PathVariable("id") Long id){
        this.iOutilService.deleteOutil(id);
    }
}
