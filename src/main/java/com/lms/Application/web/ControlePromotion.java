package com.lms.Application.web;

import com.lms.Application.entities.Niveau;
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
}
