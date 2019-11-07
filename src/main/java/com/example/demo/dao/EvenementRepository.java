package com.example.demo.dao;

import com.example.demo.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("Evenement")
public interface EvenementRepository extends JpaRepository<Evenement,Long> {
    List<Evenement> findAllById(Long id);
    List<Evenement> findAll();
    List<Evenement> findAllByDateEVTBetween(Date startDate,Date endDate);
    List<Evenement> findAllByLieu(String source);
}
