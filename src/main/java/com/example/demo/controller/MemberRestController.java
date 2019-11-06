package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MemberRestController {
    @Autowired
    IMemberService iMemberService;

    @RequestMapping(value="/members", method= RequestMethod.GET)
    public List<Member> findMembers(){
        return iMemberService.findAll();
    }
}
