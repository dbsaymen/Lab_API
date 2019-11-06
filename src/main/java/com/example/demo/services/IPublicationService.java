package com.example.demo.services;

import com.example.demo.entity.Member;
import com.example.demo.entity.Publication;

import java.util.Date;
import java.util.List;

public interface IPublicationService {
    public Publication addPub(Publication pub);
    public void deletePub(Long id);
    public void addAuthor(Member member, Publication publication);
    public Publication updatePub(Publication publication);
    public Publication findPubById(Long id);
    public List<Publication> findAllPub();
    public Publication findPubByDate(Date date);
    public List<Publication> findPubByDateBetween(Date startDate,Date endDate);
    public List<Publication> getPubByType(String type);
}
