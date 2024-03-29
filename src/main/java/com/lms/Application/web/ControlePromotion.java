package com.lms.Application.web;

import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Filiere;
import com.lms.Application.entities.Niveau;
import com.lms.Application.entities.Promotion;
import com.lms.Application.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Promotion")
public class ControlePromotion {
    @Autowired
    PromotionService PS;
    @GetMapping("/Niveaux/{id}")
    List<Niveau> getNiveaux(@PathVariable("id")Long id){
        return PS.getAllNiveaux(id);
    }
    @GetMapping("/niveau/{id}")
    public Promotion getPromotion(@PathVariable("id")Long id){
        return PS.getPromotionById(id);
    }
    @GetMapping("/students/{id}")
    List<Etudiant> getStudents(@PathVariable("id")Long id){
        return PS.getAllStudents(id);
    }
    @PostMapping("/affecterStudents/{id}")
    public boolean AddDiplome(@RequestBody List<Etudiant> etds ,@PathVariable("id")Long id){
        return PS.affecterStudents(etds,id);
    }
    @GetMapping("/filiere/{id}")
    public Filiere getFiliere(@PathVariable("id")Long id){
        return PS.getFiliere(id);
    }
}
