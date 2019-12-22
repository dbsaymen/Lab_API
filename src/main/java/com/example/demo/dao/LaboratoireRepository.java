package com.example.demo.dao;

import com.example.demo.entity.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("Laboratoire")
public interface LaboratoireRepository  extends JpaRepository<Laboratoire,Long> {
    Laboratoire findDistinctFirstById(Long id);
}
