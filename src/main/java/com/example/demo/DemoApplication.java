package com.example.demo;

import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.entity.*;
import com.example.demo.services.IMemberService;
import com.example.demo.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    RoleRepository role;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    IMemberService iMemberService;
    @Autowired
    IPublicationService publicationService;

    @Override
    public void run(String... args) throws Exception {
        role.save(new Role("Admin"));
        Etudiant m = new Etudiant("65464646","test1","test",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Member s = iMemberService.addMember(m);
        Etudiant m1 = new Etudiant("123456","Chaari","Dorra",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Member s1 = iMemberService.addMember(m1);
        Etudiant m2 = new Etudiant("321654","Ghattasi","Aycha",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Member s2 = iMemberService.addMember(m2);
        EnseignantChercheur m3 = new EnseignantChercheur("321654","Ben salem","Aymen",new Date(),"cv1.pdf",null,"test@mail.com","password");
        Member s3 = iMemberService.addMember(m2);
        Member e = iMemberService.findMember(1L);
        publicationService.addPub(new Publication("type1", new Date(), "lien1", "source1.pdf"));
        publicationService.addPub(new Publication("type2", new Date(), "lien2", "source1.pdf"));
        Publication pub= new Publication("type3", new Date(), "lien2", "source1.pdf");
        List<Member> auth=new ArrayList<Member>();
        auth.add(m2);
        //pub.setAuteurs(auth);
        publicationService.addPub(pub);



        //System.out.println("old Cin:"+e.getCin());
        //e.setCin("000000000");
        //iMemberService.updateMember(e);
        //System.out.println("new Cin:"+e.getCin());
    }
}
