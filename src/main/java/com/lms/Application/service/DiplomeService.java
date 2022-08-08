package com.lms.Application.service;

import com.lms.Application.dao.DiplomeRepository;
import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.entities.Diplome;
import com.lms.Application.entities.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiplomeService {
     @Autowired
    DiplomeRepository DR;
     @Autowired
    FiliereRepository FR;

    public Diplome getOne(Long id) {
        return DR.findById(id).get();
    }

    @Override
    public List<Diplome> getAll() {
        return DR.findAll();
    }

    @Override
    public void update(Diplome u) {
        DR.save(u);
    }

    @Override
    public void remove(Diplome s) {
        DR.delete(s);
    }

    @Override
    public Diplome add(Diplome n) {
       return DR.save(n);
    }

    public Diplome addFiliere(Filiere f,Long id) {
         Diplome d=DR.findById(id).get();
         f=FR.save(f);
    }






}