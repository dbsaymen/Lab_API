package com.example.demo.services;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entity.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EventImpl implements IEventService {

    @Autowired
    EvenementRepository evenementRepository;
    @Override
    public List<Evenement> findEvenementById(Long id) {
        return evenementRepository.findAllById(id);
    }

    @Override
    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> findEvenementByLieu(String source) {
        return evenementRepository.findAllByLieu(source);
    }

    @Override
    public List<Evenement> findEvenementByDateBetween(Date startDate, Date endDate) {
        return evenementRepository.findAllByDateEVTBetween(startDate,endDate);
    }
}
