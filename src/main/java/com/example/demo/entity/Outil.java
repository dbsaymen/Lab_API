package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Outil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String source;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany(mappedBy = "outils",targetEntity = Member.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JsonIgnore
    private List<Member> developpeurs;

    public List<Member> getDeveloppeurs() {
        return developpeurs;
    }
    public void setDeveloppeurs(List<Member> developpeurs) {
        this.developpeurs = developpeurs;
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
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Outil(String nom, String source, Date date) {
        super();
        this.nom = nom;
        this.source = source;
        this.date = date;
    }
    public Outil() {
        super();
    }
}
