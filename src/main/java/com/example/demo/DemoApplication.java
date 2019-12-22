package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    IRoleService iRoleService;
    @Autowired
    ILaboiratoireService iLaboiratoireService;
    @Autowired
    IMemberService iMemberService;
    @Autowired
    IPublicationService iPublicationService;
    @Autowired
    IOutilService iOutilService;
    @Autowired
    IEventService iEventService;

    @Override
    public void run(String... args) throws Exception {

        Etudiant m = new Etudiant("65464646","test1","test",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Etudiant m1 = new Etudiant("123456","Chaari","Dorra",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Etudiant m2 = new Etudiant("321654","Ghattasi","Aycha",new Date(),"cv1.pdf",null,"test@mail.com","password");
        EnseignantChercheur m3 = new EnseignantChercheur("321654","Ben salem","Aymen",new Date(),"cv1.pdf",null,"test@mail.com","password");

        Publication pub= new Publication("type3", new Date(), "lien2", "source1.pdf");
        Publication pub1=new Publication("type1", new Date(), "lien1", "source1.pdf");
        Publication pub2 = new Publication("type2", new Date(), "lien2", "source1.pdf");

        Laboratoire lab=new Laboratoire("RedCad","87468","ENIS","Univ sfax");

        Outil o1= new Outil("PC1","source 1",new Date());

        Evenement ev1 = new Evenement("IProtect",new Date(),"sfax");

        Role r1 = new Role("admin");

        iMemberService.addMember(m);
        iMemberService.addMember(m1);
        iMemberService.addMember(m2);

        iPublicationService.addPub(pub);
        iPublicationService.addPub(pub1);
        iPublicationService.addPub(pub2);

        iEventService.addEvenement(ev1);

        iOutilService.addOutil(o1);

        iLaboiratoireService.addLaboratoire(lab);

        m.addPublication(pub);
        m.addOutil(o1);
        m.addRole(r1);
        m.setLaboratoire(lab);
        m.addEvenment(ev1);

        iMemberService.updateMember(m);

    }
}
