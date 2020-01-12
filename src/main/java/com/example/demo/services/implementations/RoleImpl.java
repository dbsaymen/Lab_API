package com.example.demo.services.implementations;

import com.example.demo.dao.RoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl implements IRoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRolebyName(String name) {
        return this.roleRepository.findRoleByRoleName(name);
    }

    @Override
    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return this.roleRepository.saveAndFlush(role);
    }

    @Override
    public void deleteRole(String id) {
         this.roleRepository.deleteById(id);
    }
}
