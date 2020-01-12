package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnseignantChercheurReturn extends MemberReturn implements Serializable {
    private String etablissement;
    private String grade;
    private String type="enseignant";
    @JsonIgnore
    private List<EtudiantReturn> encadre;

    public List<EtudiantReturn> getEncadre() {
        return encadre;
    }

    public void setEncadre(List<Etudiant> encadre) {
        List<EtudiantReturn> etudiantReturns=new ArrayList<>();
        for(Etudiant e: encadre){
            EtudiantReturn er=new EtudiantReturn();
            BeanUtils.copyProperties(e,er);
            etudiantReturns.add(er);
        }

        this.encadre = etudiantReturns;
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

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    public EnseignantChercheurReturn() {
    }

    public EnseignantChercheurReturn(String etablissement, String grade) {
        this.etablissement = etablissement;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "EnsegnantChercheurReturn";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.toString().equals(this.toString())) return true;
        return false;
    }
}
