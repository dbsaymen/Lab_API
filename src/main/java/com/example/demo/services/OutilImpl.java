package com.example.demo.services;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entity.Outil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutilImpl implements IOutilService {
    @Autowired
    OutilRepository outilRepository;

    @Override
    public Outil getOutilById(Long id) {
        return outilRepository.findAllById(id);
    }

    @Override
    public Outil addOutil(Outil outil) {
        return this.outilRepository.save(outil);
    }

    @Override
    public Outil updateOutil(Outil outil) {
        return this.outilRepository.saveAndFlush(outil);
    }

    @Override
    public void deleteOutil(Long id) {
        this.outilRepository.deleteById(id);
    }

    @Override
    public List<Outil> findAll() {
        return this.outilRepository.findAll();
    }
}
