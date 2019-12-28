package com.example.demo.entity;

import java.util.Date;
import java.util.List;

public class MemberReturn {
    private String publicID;
    private String cin;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String cv;
    private byte[] photo;
    private String email;
    private List<Publication> pubs;
    private List<Evenement> evts;
    private List<Outil> outils;
    private Laboratoire laboratoire;
    private List<Role> roles;

    public MemberReturn() {
    }

    public MemberReturn(String publicID, String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo, String email) {
        this.publicID = publicID;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cv = cv;
        this.photo = photo;
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPublicID() {
        return publicID;
    }

    public void setPublicID(String publicID) {
        this.publicID = publicID;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Publication> getPubs() {
        return pubs;
    }

    public void setPubs(List<Publication> pubs) {
        this.pubs = pubs;
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

    public Laboratoire getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(Laboratoire laboratoire) {
        this.laboratoire = laboratoire;
    }

    @Override
    public String toString() {
        return "MemberReturn";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.toString().equals(this.toString())) return true;
        return false;
    }

}
