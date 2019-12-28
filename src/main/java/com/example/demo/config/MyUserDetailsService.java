package com.example.demo.config;

import com.example.demo.entity.Member;
import com.example.demo.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    IMemberService iMemberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member= iMemberService.findByEmail(email);
        UserDetails userDetails=new MyUserDetails(member);
        return userDetails;
    }
}
