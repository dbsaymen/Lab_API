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
        Member member = memberService.findDistinctByPublicID(publicId);
        if (member != null) {
            MemberReturn mr = new MemberReturn();
            BeanUtils.copyProperties(member, mr);
            return mr;
        } else {
            throw new org.springframework.security.access.AccessDeniedException("401 returned");
        }

    }

    @GetMapping(value = "/login")
    public MemberReturn Login(@RequestParam("email") String email) {
        if (email != null) {
            Member member = memberService.findByEmail(email);
            MemberReturn memberReturn;
            if (member != null) {
                if (member.toString().equals("Etudiant"))
                    memberReturn = new EtudiantReturn();
                else
                    memberReturn = new EnseignantChercheurReturn();
                BeanUtils.copyProperties(member, memberReturn);
                return memberReturn;
            } else {
                throw new org.springframework.security.access.AccessDeniedException("401 returned");
            }
        } else {
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
                Etudiant m =(Etudiant) memberService.findDistinctByPublicID(publicId);
                if(e.getCin()!=null)m.setCin(e.getCin());
                if(e.getEmail()!=null)m.setEmail(e.getEmail());
                if(e.getCv()!=null)m.setCv(e.getCv());
                if(e.getPassword()!=null)m.setPassword(e.getPassword());
                if(e.getDiplome()!=null)m.setDiplome(e.getDiplome());
                if(e.getDateInscription()!=null)m.setDateInscription(e.getDateInscription());
                MemberReturn mr = new EtudiantReturn();
                BeanUtils.copyProperties(memberService.updateMember(m), mr);
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
                EnseignantChercheur m =(EnseignantChercheur) memberService.findDistinctByPublicID(publicId);
                if(e.getCin()!=null)m.setCin(e.getCin());
                if(e.getEmail()!=null)m.setEmail(e.getEmail());
                if(e.getCv()!=null)m.setCv(e.getCv());
                if(e.getPassword()!=null)m.setPassword(e.getPassword());
                if(e.getEtablissement()!=null)m.setEtablissement(e.getEtablissement());
                if(e.getGrade()!=null)m.setGrade(e.getGrade());
                MemberReturn mr = new EnseignantChercheurReturn();
                BeanUtils.copyProperties(memberService.updateMember(m), mr);
                return mr;
            }
        }
        return null;
    }

}
