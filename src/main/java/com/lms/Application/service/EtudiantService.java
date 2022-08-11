package com.lms.Application.service;

import com.lms.Application.dao.EtudiantRepository;
import com.lms.Application.dao.NiveauRepository;
import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Etudiant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EtudiantService {
    private final FiliereService fs;
    private final EtudiantRepository er;
    private final RoleRepository rr;
    private final NiveauRepository NR;
    public EtudiantService(FiliereService fs, EtudiantRepository er, RoleRepository rr, NiveauRepository nr) {
        this.fs = fs;
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


    public Etudiant addEtudiant(Etudiant c,Long idFiliere) {
        c.addRole( rr.findByRole("student"));
        c=er.save(c);
        fs.addEtudiant(c,idFiliere);
        return c;
    }


    public Page<Etudiant> chercherEtudiant(String mc, int page, int size) {
        return er.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }

    public Long getcard(){


        return er.count();
    }

}
