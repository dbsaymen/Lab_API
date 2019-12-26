package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 3)
public class Member implements Serializable {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String publicID;
    @Column(nullable = false, length = 50, unique = true)
    private String cin;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 50)
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String cv;
    @Lob
    private byte[] photo;
    @Column(nullable = false, length = 150, unique = true)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String password;


    //Relations
    @ManyToMany(targetEntity = Role.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private List<Role> roles;

    @ManyToMany(targetEntity = Publication.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Publication> pubs;

    @ManyToMany(targetEntity = Evenement.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Evenement> evts;

    @ManyToMany(targetEntity = Outil.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Outil> outils;

    @ManyToOne(targetEntity = Laboratoire.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private Laboratoire laboratoire;

    public void addRole(Role role) {
        if (this.roles == null)
            this.roles = new ArrayList<Role>();
        this.roles.add(role);
    }

    public String getPublicID() {
        return publicID;
    }

    public void setPublicID(String publicID) {
        this.publicID = publicID;
    }

    public void addEvenment(Evenement evenement) {
        if (this.evts == null)
            this.evts = new ArrayList<Evenement>();
        this.evts.add(evenement);
    }

    public void addPublication(Publication publication) {
        if (this.pubs == null)
            this.pubs = new ArrayList<Publication>();
        this.pubs.add(publication);
    }

    public void addOutil(Outil outil) {
        if (this.outils == null)
            this.outils = new ArrayList<Outil>();
        this.outils.add(outil);
    }

    public Laboratoire getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(Laboratoire laboratoire) {
        this.laboratoire = laboratoire;
    }

    public List<Evenement> getEvts() {
        return evts;
    }

    public void setEvts(List<Evenement> evts) {
        this.evts = evts;
    }

    public List<Outil> getOutils() {
        return outils;
    }

    public void setOutils(List<Outil> outils) {
        this.outils = outils;
    }

    public List<Publication> getPubs() {
        return pubs;
    }

    public void setPubs(List<Publication> pubs) {
        this.pubs = pubs;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Member() {
        super();
    }

    public Member(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo, String email, String password) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cv = cv;
        this.photo = photo;
        this.email = email;
        this.password = password;
    }


}

