package com.example.demo.controller;

import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Member;
import com.example.demo.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberRestController {
    @Autowired
    IMemberService memberService;

    @GetMapping(value="/")
    public List<Member> findMembers(){
        return memberService.findAll();
    }
    @GetMapping(value="/{id}")
    public Member findMembersById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }
    @PostMapping(value = "/etudiant")
    public Member addEtudiant(@RequestBody Etudiant e){
        return memberService.addMember(e);
    }
    @DeleteMapping(value = "/etudiant/{id}")
    public void deleteEtudiant (@PathVariable("id") Long id){
        memberService.deleteMember(id);
    }
    @PutMapping(value="/etudiant/{id}")
    public Member updateEtudiant(@PathVariable("id")Long id, @RequestBody Etudiant e){
        e.setId(id);
        return memberService.updateMember(e) ;
    }


    @PostMapping(value = "/enseignant")
    public Member addEnseignant(@RequestBody EnseignantChercheur e){
        return memberService.addMember(e);
    }
    @DeleteMapping(value = "/enseignant/{id}")
    public void deleteEnseignant (@PathVariable("id") Long id){
        memberService.deleteMember(id);
    }
    @PutMapping(value="/enseignant/{id}")
    public Member updateEnseignant(@PathVariable("id")Long id, @RequestBody EnseignantChercheur e){
        e.setId(id);
        return memberService.updateMember(e) ;
    }

}
