package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateEVT;
    private String lieu;

    @ManyToMany
    @JsonIgnore
    private List<Member> organisateurs;

    public List<Member> getOrganisateurs() {
        return organisateurs;
    }
    public void setOrganisateurs(List<Member> organisateurs) {
        this.organisateurs = organisateurs;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Date getDateEVT() {
        return dateEVT;
    }
    public void setDateEVT(Date dateEVT) {
        this.dateEVT = dateEVT;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public Evenement() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Evenement(String nom, Date dateEVT, String lieu) {
        super();
        this.nom = nom;
        this.dateEVT = dateEVT;
        this.lieu = lieu;
    }


}
