package com.lms.Application.service;

import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfService  {
    @Autowired
    private final ProfesseurRepository pr;
    @Autowired
    private final RoleRepository r;

    public ProfService(ProfesseurRepository pr, RoleRepository r) {
        this.pr = pr;
        this.r = r;
    }
    public Page<Professeur> findPage(int pageNumber){

        return pr.findAll(PageRequest.of(pageNumber,6));
    }
    public Professeur findProfesseurbyId(Long id) {
        return pr.findById(id).get();
    }


    public Professeur updateProfesseur(Professeur c) {
        return pr.save(c);

    }


    public void deleteProfesseur(Long id) {
        Professeur p=pr.findById(id).get();

        p.getMaFiliere().setChefFiliere(null);
        p.setMaFiliere(null);
        pr.deleteById(id);

    }


    public Professeur addProfesseur(Professeur c,String role) {

        c.addRole( r.findByRole(role));

        return  pr.save(c);
    }


    public Page<Professeur> chercherProf(String mc, int page, int size) {
        return pr.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }

    public Professeur findProfbyId(Long id) {

        return pr.findById(id).orElse(null);
    }
    public Long getcard(){
        return pr.count();
    }

    public List<Professeur> getProfs(){
        return this.pr.findAll();
    }

}
