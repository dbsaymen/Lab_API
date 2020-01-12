package com.example.demo.services;

import com.example.demo.entity.Evenement;

import java.util.Date;
import java.util.List;

public interface IEventService {
    List<Evenement> findEvenementById(Long id);
    List<Evenement> findAll();
    List<Evenement> findEvenementByLieu(String source);
    List<Evenement> findEvenementByDateBetween(Date startDate, Date endDate);
    Evenement addEvenement(Evenement evenement);
    Evenement updateEvenement(Evenement evenement);
    void deleteEvenement(Long id);
}
