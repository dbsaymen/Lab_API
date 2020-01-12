package com.example.demo.services.implementations;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entity.Member;
import com.example.demo.entity.Publication;
import com.example.demo.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PublicationImpl implements IPublicationService {
    @Autowired
    PublicationRepository publicationRepository;


    @Override
    public Publication findPubById(Long id) {
        return publicationRepository.findDistinctById(id);
    }

    @Override
    public Publication addPub(Publication pub) {
        return publicationRepository.save(pub);
    }

    @Override
    public void deletePub(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public void addAuthor(Member member, Publication publication) {
        publication.addAuthor(member);
        publicationRepository.saveAndFlush(publication);
    }

    @Override
    public Publication updatePub(Publication publication) {
        return publicationRepository.saveAndFlush(publication);
    }



    @Override
    public List<Publication> findAllPub() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication findPubByDate(Date date) {
        return publicationRepository.findDistinctByDateApparition(date);
    }

    @Override
    public List<Publication> findPubByDateBetween(Date startDate, Date endDate) {
        return publicationRepository.findAllByDateApparitionBetween(startDate,endDate);
    }

    @Override
    public List<Publication> getPubByType(String type) {
        return publicationRepository.findAllByType(type);
    }
}
