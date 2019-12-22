package com.example.demo.services;

import com.example.demo.entity.Laboratoire;

public interface ILaboiratoireService {
    public Laboratoire getLaboratoire(Long id);
    public Laboratoire addLaboratoire(Laboratoire laboratoire);
    public Laboratoire updateLaboratoire(Laboratoire laboratoire);
    public void deleteLaboratoire(Long id);

}
