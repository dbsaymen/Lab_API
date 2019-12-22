package com.example.demo.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member implements Serializable{
    private String etablissement;
    private String grade;
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


}
