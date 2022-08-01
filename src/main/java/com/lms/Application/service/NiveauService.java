package com.lms.Application.service;

import com.lms.Application.dao.NiveauRepository;
import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class NiveauService {
    private final NiveauRepository nr;

    public NiveauService(NiveauRepository nr) {
        this.nr = nr;
    }

    public Niveau findEtudiantbyId(Long id) {

        return nr.findById(id).get();
    }




    public void deleteNiveau(Long id) {
        nr.deleteById(id);

    }


    public Niveau addNiveau(Niveau c) {

        nr.save(c);
        return c;
    }
    public List<Niveau> getNiveaux() {

        return nr.findAll();
    }






}
