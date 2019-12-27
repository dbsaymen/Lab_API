package com.example.demo.entity;


import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

public class EtudiantReturn extends MemberReturn implements Serializable {
    private Date dateInscription;
    private String sujet;
    private String diplome;
    private EnseignantChercheurReturn encadrant;


    public EtudiantReturn() {
    }

    public EtudiantReturn(Date dateInscription, String sujet, String diplome, EnseignantChercheurReturn encadrant) {
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }

    public void setEncadrant(EnseignantChercheurReturn encadrant) {
        this.encadrant = encadrant;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public EnseignantChercheurReturn getEncadrant() {
        return encadrant;
    }

    @Override
    public String toString() {
        return "EtudiantReturn";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.toString().equals(this.toString())) return true;
        return false;
    }
}
