package com.lms.Application.service;

import com.lms.Application.dao.EtudiantRepository;
import com.lms.Application.dao.NiveauRepository;
import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Etudiant;

import com.lms.Application.entities.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EtudiantService {

    private final EtudiantRepository er;
    private final RoleRepository rr;
    private final NiveauRepository NR;
    public EtudiantService(EtudiantRepository er, RoleRepository rr, NiveauRepository nr) {
        this.er = er;
        this.rr = rr;
        NR = nr;
    }


    public Page<Etudiant> findPage(int pageNumber){

        return er.findAll(PageRequest.of(pageNumber,6));
    }
    public Etudiant findEtudiantbyId(Long id) {
        return er.findById(id).get();
    }


    public Etudiant updateEtudiant(Etudiant c) {
        return er.save(c);

    }


    public void deleteEtudiant(Long id) {
        er.deleteById(id);

    }


    public Etudiant addEtudiant(Etudiant c,String role) {
        c.addRole( rr.findByRole(role));
        er.save(c);

        return c;
    }


    public Page<Etudiant> chercherEtudiant(String mc, int page, int size) {
        return er.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }

    public Long getcard(){


        return er.count();
    }


    public Etudiant adde(Etudiant s, Long id){
        Niveau f=this.NR.findById(id).get();
        s.getRoles().add(rr.findByRole("student"));
        Etudiant ss=this.er.save(s);
        f.addStudent(ss);
        this.NR.save(f);

        return this.er.findById(ss.getId()).get();
    }


    public void setDemanded(Long id) {
        Etudiant s= this.er.findById(id).get();
        s.setDemanded();
        this.er.save(s);
    }


    public void setAffected(Long id) {
        Etudiant s= this.er.findById(id).get();
        s.setAffected();
        this.er.save(s);
    }


    public void setrefused(Long id) {
        Etudiant s= this.er.findById(id).get();
        s.setRefused();
        this.er.save(s);
    }

}
