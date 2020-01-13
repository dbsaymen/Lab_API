package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
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
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return (new BCryptPasswordEncoder());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Etudiant m = new Etudiant("65464646", "test1", "test", new Date(), "cv1.pdf", null, "user@mail.com", "user",new Date(),"sujet1","thèse");
        Etudiant m1 = new Etudiant("123456", "Chaari", "Dorra", new Date(), "cv1.pdf", null, "test2@mail.com", "password",new Date(),"sujet2","mastère");
        Etudiant m2 = new Etudiant("321654", "Ghattasi", "Aycha", new Date(), "cv1.pdf", null, "test3@mail.com", "password",new Date(),"sujet3","thèse");
        EnseignantChercheur m3 = new EnseignantChercheur("464516", "Ben salem", "Aymen", new Date(), "cv1.pdf", null, "test@mail.com", "password","MA");

        Publication pub = new Publication("type3", new Date(), "lien2", "source1.pdf");
        Publication pub1 = new Publication("type1", new Date(), "lien1", "source1.pdf");
        Publication pub2 = new Publication("type2", new Date(), "lien2", "source1.pdf");

        Laboratoire lab = new Laboratoire("RedCad", "87468", "ENIS", "Univ sfax");

        Outil o1 = new Outil("PC1", "source 1", new Date());

        Evenement ev1 = new Evenement("IProtect", new Date(), "sfax");

        Role r1 = new Role("ADMIN");
        Role r2 = new Role("USER");

        iMemberService.addMember(m);
        iMemberService.addMember(m1);
        iMemberService.addMember(m2);
        iMemberService.addMember(m3);

        iPublicationService.addPub(pub);
        iPublicationService.addPub(pub1);
        iPublicationService.addPub(pub2);

        iEventService.addEvenement(ev1);

        iOutilService.addOutil(o1);

        iLaboiratoireService.addLaboratoire(lab);

        m.addPublication(pub);
        m.addOutil(o1);
        m.addRole(r1);
        m1.addRole(r2);
        m2.addRole(r2);
        m.setLaboratoire(lab);
        m.addEvenment(ev1);

        iMemberService.updateMember(m);
        iMemberService.updateMember(m1);
        iMemberService.updateMember(m2);

    }


}
