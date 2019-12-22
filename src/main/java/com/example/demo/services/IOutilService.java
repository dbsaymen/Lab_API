package com.example.demo.services;

import com.example.demo.entity.Outil;

import java.util.List;

public interface IOutilService {
    public Outil getOutilById(Long id);
    public Outil addOutil(Outil outil);
    public Outil updateOutil(Outil outil);
    public void deleteOutil(Long id);
    List<Outil> findAll();
}
