package com.example.demo.services;

import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IMemberService extends UserDetailsService {
    public Member addMember(Member m);

    public void deleteMember(String id);

    public Member updateMember(Member p);

    Member findDistinctByPublicID(String publicID);

    public Member findMember(Long id);

    public List<Member> findAll();

    public Member findByCin(String cin);

    public Member findByEmail(String email);

    public List<Member> findByNom(String nom);

    public List<Etudiant> findByDiplome(String diplome);

    public List<EnseignantChercheur> findByGrade(String grade);

    public List<EnseignantChercheur> findByEtablissement(String etablissement);

    Member findById(Long id);
}
