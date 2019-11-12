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
public class MemberRestController {
    @Autowired
    IMemberService memberService;

    @GetMapping(value="/members")
    public List<Member> findMembers(){
        return memberService.findAll();
    }
    @GetMapping(value="/members/{id}")
    public Member findMembersById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }
    @PostMapping(value = "/member/etudiant")
    public Member addEtudiant(@RequestBody Etudiant e){
        return memberService.addMember(e);
    }
    @DeleteMapping(value = "/member/etudiant/{id}")
    public void deleteEtudiant (@PathVariable("id") Long id){
        memberService.deleteMember(id);
    }
    @PutMapping(value="member/etudiant/{id}")
    public Member updateEtudiant(@PathVariable("id")Long id, @RequestBody Etudiant e){
        e.setId(id);
        return memberService.updateMember(e) ;
    }


    @PostMapping(value = "/member/enseignant")
    public Member addEnseignant(@RequestBody EnseignantChercheur e){
        return memberService.addMember(e);
    }
    @DeleteMapping(value = "/member/enseignant/{id}")
    public void deleteEnseignant (@PathVariable("id") Long id){
        memberService.deleteMember(id);
    }
    @PutMapping(value="member/enseignant/{id}")
    public Member updateEnseignant(@PathVariable("id")Long id, @RequestBody EnseignantChercheur e){
        e.setId(id);
        return memberService.updateMember(e) ;
    }

}
