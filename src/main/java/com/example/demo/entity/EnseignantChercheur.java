package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member implements Serializable {
    private String etablissement;
    private String grade;
    @OneToMany(mappedBy = "encadrant")
    @JsonIgnore
    private List<Etudiant> encadre;

    public List<Etudiant> getEncadre() {
        return encadre;
    }

    public void setEncadre(List<Etudiant> encadre) {
        this.encadre = encadre;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public EnseignantChercheur() {
        super();
    }

    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo,
                               String email, String password) {
        super(cin, nom, prenom, dateNaissance, cv, photo, email, password);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "EnseignantChercheur";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.toString().equals(this.toString())) return true;
        return false;
    }
}
