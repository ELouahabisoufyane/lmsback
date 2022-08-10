package com.lms.Application.service;
import com.lms.Application.dao.EtudiantRepository;
import com.lms.Application.dao.InscriptionRepository;
import com.lms.Application.dao.PromotionRepository;
import com.lms.Application.entities.*;
import com.lms.Application.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
@Service
@Transactional

public class PromotionService {
    @Autowired
    PromotionRepository PromR;
    @Autowired
    EtudiantRepository er;
    private final InscriptionRepository IR;

    public PromotionService(InscriptionRepository ir) {
        IR = ir;
    }

    public List<Promotion> getAllPromotions(){
        return PromR.findAll();
    }

    public List<Etudiant> getAllStudents(Long idPromotion){
        Promotion p= PromR.findById(idPromotion).get();
        return p.getEtudiants();
    }
   public List<Niveau> getAllNiveaux(Long idPromotion){
        Promotion p= PromR.findById(idPromotion).get();
        return p.getNiveaux();
    }
    public Promotion getPromotionById(Long id){
        return  PromR.findById(id).get();
    }
    public boolean affecterStudents(List<Etudiant> etds ,Long idPromo){
        Promotion p=PromR.findById(idPromo).get();

        for (Etudiant e:etds){
            for(Semestre s:p.getNiveaux().get(0).getSemestres()){
                for(Module m:s.getModules()) {
                    Inscription i=new Inscription();
                    i=IR.save(i);
                    Etudiant student=er.findById(e.getId()).get();
                    student.setSelec(true);
                    student=er.save(student);
                    student.addInscription(i);
                    m.addInscription(i);



                }
            }
        }
        return true;}



}
