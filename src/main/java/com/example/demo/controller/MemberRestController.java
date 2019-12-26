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

    @GetMapping(value = "/")
    public List<Member> findMembers() {
        return memberService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Member findMembersById(@PathVariable("id") String id) {
        return memberService.findDistinctByPublicID(id);
    }

    @PostMapping(value = "/etudiant")
    public Member addEtudiant(@RequestBody Etudiant e) {
        return memberService.addMember(e);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEtudiant(@PathVariable("id") String id) {
        memberService.deleteMember(id);
    }

    @PutMapping(value = "/etudiant/{id}")
    public Member updateEtudiant(@PathVariable("id") String pubId, @RequestBody Etudiant e) {
        Long id = memberService.findDistinctByPublicID(pubId).getId();
        e.setId(id);
        return memberService.updateMember(e);
    }

    @PostMapping(value = "/enseignant")
    public Member addEnseignant(@RequestBody EnseignantChercheur e) {
        return memberService.addMember(e);
    }

    @PutMapping(value = "/enseignant/{id}")
    public Member updateEnseignant(@PathVariable("id") String pubId, @RequestBody EnseignantChercheur e) {
        Long id = memberService.findDistinctByPublicID(pubId).getId();
        e.setId(id);
        return memberService.updateMember(e);
    }

}
