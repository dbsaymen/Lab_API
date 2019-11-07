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
    public List<Outil> getOutilById(Long id) {
        return outilRepository.findAllById(id);
    }
}