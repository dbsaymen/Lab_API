package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("role")
public interface RoleRepository extends JpaRepository<Role,String> {
    Role findRoleByRoleName(String name);

}
