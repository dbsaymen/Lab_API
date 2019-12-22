package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {
    @Id
    private String roleName;
    @ManyToMany
    @JsonIgnore
    private List<Member> members;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
        super();
    }

    public Role(String roleName) {
        super();
        this.roleName = roleName;
    }


}
