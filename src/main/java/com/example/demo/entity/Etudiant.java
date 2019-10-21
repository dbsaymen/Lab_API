package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Member implements Serializable{
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    private String sujet;
    private String diplome;

    //relation : a un encadrant par défaut est eager
    //@ManyToOne
    @ManyToOne(fetch=FetchType.LAZY)
    private EnseignantChercheur encadrant;

    public EnseignantChercheur getEncadrant() {
        return encadrant;
    }
    public void setEncadrant(EnseignantChercheur encadrant) {
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
    public Etudiant() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo,
                    String email, String password) {
        super(cin, nom, prenom, dateNaissance, cv, photo, email, password);
        // TODO Auto-generated constructor stub
    }
    public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo, String email,
                    String password, Date dateInscription, String sujet, String diplome) {
        super(cin, nom, prenom, dateNaissance, cv, photo, email, password);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
    }



}

