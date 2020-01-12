package com.example.demo.config;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;
import com.example.demo.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    Member userInformations;

    public MyUserDetails() {
    }
    public MyUserDetails(Member memeber) {
        this.userInformations=memeber;
        System.out.println(userInformations.getEmail());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList authorities= new ArrayList<>();
        List<Role> roles=this.userInformations.getRoles();
        for(Role r : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userInformations.getPassword();
    }

    @Override
    public String getUsername() {
        return userInformations.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userInformations.isActivated();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userInformations.isActivated();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userInformations.isActivated();
    }
    public Member getMember(){
        return this.userInformations;
    }

}
