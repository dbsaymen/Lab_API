package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.services.IMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberRestController {
    @Autowired
    IMemberService memberService;

    @GetMapping(value = "/")
    public List<MemberReturn> findMembers() {
        List<Member> members = memberService.findAll();
        List<MemberReturn> memberReturns = new ArrayList<>();
        for (Member m : members) {
            MemberReturn mr;
            if (m.toString().equals("Etudiant"))
                mr = new EtudiantReturn();
            else
                mr = new EnseignantChercheurReturn();
            BeanUtils.copyProperties(m, mr);
            memberReturns.add(mr);
        }
        return memberReturns;
    }

    @GetMapping(value = "/{id}")
    public MemberReturn findMembersById(@PathVariable("id") String publicId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if (memberService.findByEmail(currentUserName).getPublicID().equals(publicId) || memberService.findByEmail(currentUserName).hasRole("ADMIN")) {
                MemberReturn mr = new MemberReturn();
                BeanUtils.copyProperties(memberService.findDistinctByPublicID(publicId), mr);
                return mr;
            }
        }
        return null;
    }

    @GetMapping(value = "/login")
    public MemberReturn Login(@RequestParam("email") String email) {
        if(email!=null){
            Member member=memberService.findByEmail(email);
            if(member !=null){
                MemberReturn memberReturn= new MemberReturn();
                BeanUtils.copyProperties(member, memberReturn);
                return memberReturn;
            }else {
                throw new org.springframework.security.access.AccessDeniedException("401 returned");
            }
        }else {
            throw new org.springframework.security.access.AccessDeniedException("401 returned");
        }

    }


    @PostMapping(value = "/etudiant")
    public MemberReturn addEtudiant(@RequestBody Etudiant e) {
        MemberReturn mr = new EtudiantReturn();
        Member m = memberService.addMember(e);
        BeanUtils.copyProperties(m, mr);
        return mr;
    }

    @DeleteMapping(value = "/{publicId}")
    public void deleteEtudiant(@PathVariable("publicId") String publicId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if (memberService.findByEmail(currentUserName).getPublicID().equals(publicId) || memberService.findByEmail(currentUserName).hasRole("ADMIN"))
                memberService.deleteMember(publicId);
        }
    }

    @PutMapping(value = "/etudiant/{publicId}")
    public MemberReturn updateEtudiant(@PathVariable("publicId") String publicId, @RequestBody Etudiant e) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if (memberService.findByEmail(currentUserName).getPublicID().equals(publicId) || memberService.findByEmail(currentUserName).hasRole("ADMIN")) {
                Long id = memberService.findDistinctByPublicID(publicId).getId();
                e.setId(id);
                MemberReturn mr = new EtudiantReturn();
                BeanUtils.copyProperties(memberService.updateMember(e), mr);
                return mr;
            }
        }
        return null;
    }

    @PostMapping(value = "/enseignant")
    public MemberReturn addEnseignant(@RequestBody EnseignantChercheur e) {
        MemberReturn mr = new EnseignantChercheurReturn();
        BeanUtils.copyProperties(memberService.addMember(e), mr);
        return mr;
    }

    @PutMapping(value = "/enseignant/{id}")
    public MemberReturn updateEnseignant(@PathVariable("id") String publicId, @RequestBody EnseignantChercheur e) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if (memberService.findByEmail(currentUserName).getPublicID().equals(publicId) || memberService.findByEmail(currentUserName).hasRole("ADMIN")) {
                Long id = memberService.findDistinctByPublicID(publicId).getId();
                e.setId(id);
                MemberReturn mr = new EnseignantChercheurReturn();
                BeanUtils.copyProperties(memberService.updateMember(e), mr);
                return mr;
            }
        }
        return null;
    }

}
