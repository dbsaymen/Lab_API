package com.example.demo.dao;

import com.example.demo.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
}
