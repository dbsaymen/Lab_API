package com.example.demo.dao;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("member")
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByCin(String cin);
    List<Member> findByNomStartingWith(String caractere);
    Member findByEmail(String email);
}
