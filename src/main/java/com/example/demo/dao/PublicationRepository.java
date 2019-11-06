package com.example.demo.dao;

import com.example.demo.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository("Publication")
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    Publication findDistinctById (Long Id);
    List<Publication> findAll ();
    List<Publication> findAllByDateApparitionBetween(Date startDate, Date endDate);
    Publication findDistinctByDateApparition(Date date);
    List<Publication> findAllByType(String type);
}
