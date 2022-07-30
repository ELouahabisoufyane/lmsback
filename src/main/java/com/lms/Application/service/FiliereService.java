package com.lms.Application.service;

import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.Filiere;
import com.lms.Application.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FiliereService {
    private final FiliereRepository fr;
    private final ProfesseurRepository pr;
    public FiliereService(FiliereRepository fr, ProfesseurRepository pr) {
        this.fr = fr;
        this.pr = pr;
    }

    public Filiere addFiliere(Filiere c,String n) {


        c.setprof(pr.findByUsername(n));


        return fr.save(c);
    }


    public Page<Filiere> findPage(int pageNumber){

        return fr.findAll(PageRequest.of(pageNumber,6));
    }
    public Filiere findFilierebyId(Long id) {
        return fr.findById(id).get();
    }


    public Filiere updateFiliere(Filiere c) {
        return fr.save(c);

    }


    public void deleteFiliere(Long id) {
        Filiere f=fr.findById(id).get();
        f.getChefFiliere().setMaFiliere(null);
        fr.delete(f);


    }




    public Page<Filiere> chercherFiliere(String mc, int page, int size) {
        return fr.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }

    public Long getcard(){


        return fr.count();
    }

    public Professeur getChef(Filiere f){
        return f.getChefFiliere();
    }
    public Filiere updateChef(Filiere f,String n){

        f.updateprof(null);
        f=fr.save(f);
        f.setprof(pr.findByUsername(n));
        return fr.save(f);
    }


}
