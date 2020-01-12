package com.example.demo.services.implementations;

import com.example.demo.dao.LaboratoireRepository;
import com.example.demo.entity.Laboratoire;
import com.example.demo.services.ILaboiratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoireImpl implements ILaboiratoireService {
    @Autowired
    LaboratoireRepository laboratoireRepository;

    @Override
    public Laboratoire getLaboratoire(Long id) {
        return this.laboratoireRepository.findDistinctFirstById(id);
    }

    @Override
    public Laboratoire addLaboratoire(Laboratoire laboratoire) {
        return this.laboratoireRepository.save(laboratoire); }

    @Override
    public Laboratoire updateLaboratoire(Laboratoire laboratoire) {
        return this.laboratoireRepository.saveAndFlush(laboratoire);
    }

    @Override
    public void deleteLaboratoire(Long id) {
        this.laboratoireRepository.deleteById(id);
    }
}
