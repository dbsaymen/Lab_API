package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.services.ILaboiratoireService;
import com.example.demo.services.IMemberService;
import com.example.demo.services.IPublicationService;
import com.example.demo.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    IPublicationService publicationService;

    @Override
    public void run(String... args) throws Exception {
        iRoleService.addRole(new Role("Admin"));
        Etudiant m = new Etudiant("65464646","test1","test",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Etudiant m1 = new Etudiant("123456","Chaari","Dorra",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Etudiant m2 = new Etudiant("321654","Ghattasi","Aycha",new Date(),"cv1.pdf",null,"test@mail.com","password");
        EnseignantChercheur m3 = new EnseignantChercheur("321654","Ben salem","Aymen",new Date(),"cv1.pdf",null,"test@mail.com","password");
        iMemberService.addMember(m);
        iMemberService.addMember(m1);
        iMemberService.addMember(m2);
        Publication pub= new Publication("type3", new Date(), "lien2", "source1.pdf");
        Publication pub1=new Publication("type1", new Date(), "lien1", "source1.pdf");
        Publication pub2 = new Publication("type2", new Date(), "lien2", "source1.pdf");
        publicationService.addPub(pub);
        publicationService.addPub(pub1);
        publicationService.addPub(pub2);
        List<Member> auth= Arrays.asList(m);
        pub.setAuteurs(auth);
        publicationService.updatePub(pub);
        publicationService.addPub(pub);

        Laboratoire lab=new Laboratoire();
        iLaboiratoireService.addLaboratoire(lab);
        m.setLaboratoire(lab);
        iMemberService.updateMember(m);

    }
}
