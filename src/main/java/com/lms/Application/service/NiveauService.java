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
import java.util.Set;

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

    public Set<Etudiant> getEtudiantByid(Long id){
        Niveau n=nr.findById(id).get();
        return n.getStudents();

    }


    public List<Etudiant> getRejectedStudents(Long id) {
        return this.nr.findById(id).get().getExlcusedStudent();
    }

    public List<Etudiant> getDemandeStudents(Long id) {
        return this.nr.findById(id).get().getDemandeStudent();
    }

    public List<Etudiant> getAffectedStudents(Long id) {
        return this.nr.findById(id).get().getAffecteStudent();
    }

    public Set<Etudiant> getStudents(Long id) {
        return this.nr.findById(id).get().getStudents();
    }




}
