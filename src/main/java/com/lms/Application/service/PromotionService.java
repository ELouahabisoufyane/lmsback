package com.lms.Application.service;
import com.lms.Application.dao.PromotionRepository;
import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Niveau;
import com.lms.Application.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
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
