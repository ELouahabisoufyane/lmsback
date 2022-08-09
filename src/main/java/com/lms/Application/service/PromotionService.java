package com.lms.Application.service;
import com.lms.Application.dao.PromotionRepository;
import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Niveau;
import com.lms.Application.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class PromotionService {
    @Autowired
    PromotionRepository PromR;

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
}
