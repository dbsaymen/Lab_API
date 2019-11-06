package com.example.demo.dao;

import com.example.demo.entity.Outil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Outil")
public interface OutilRepository extends JpaRepository<Outil,Long> {
    List<Outil> findAllById(Long id);
}
