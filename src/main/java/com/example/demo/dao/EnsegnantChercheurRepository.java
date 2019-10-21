package com.example.demo.dao;

import com.example.demo.entity.EnseignantChercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EnsegnantChercheur")
public interface EnsegnantChercheurRepository extends JpaRepository<EnseignantChercheur,Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur> findByEtablissement(String etablissement);
}
