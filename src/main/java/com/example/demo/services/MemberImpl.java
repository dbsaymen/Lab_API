package com.example.demo.services;

import com.example.demo.dao.MemberRepository;
import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Member;
import com.example.demo.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberImpl implements IMemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Member addMember(Member m) {
        String publicID;
        do {
            publicID = utils.generateUserID();
        } while (memberRepository.findDistinctByPublicID(publicID) != null);
        m.setPublicID(publicID);
        if(m.getPassword()!=null)
            m.setPassword(this.bCryptPasswordEncoder.encode(m.getPassword()));
        else
            return null;
        return memberRepository.save(m);
    }

    @Override
    public void deleteMember(String id) {
        Member m =memberRepository.findDistinctByPublicID(id);
        memberRepository.deleteById(m.getId());
    }

    @Override
    public Member updateMember(Member p) {
        return memberRepository.saveAndFlush(p);
    }

    @Override
    public Member findDistinctByPublicID(String publicID) {
        return memberRepository.findDistinctByPublicID(publicID);
    }

    @Override
    public Member findMember(Long id) {
        Member m = (Member) memberRepository.findById(id).get();
        return m;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findByCin(String cin) {
        return memberRepository.findByCin(cin);
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Member> findByNom(String nom) {
        return memberRepository.findByNomStartingWith(nom);
    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
        return null;
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
        return null;
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findDistinctById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
