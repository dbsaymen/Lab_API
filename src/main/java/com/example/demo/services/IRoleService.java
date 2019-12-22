package com.example.demo.services;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;


public interface IRoleService  {
    public Role addRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(String id);
}
