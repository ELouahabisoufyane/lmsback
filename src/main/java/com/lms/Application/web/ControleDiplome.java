package com.lms.Application.web;

import com.lms.Application.entities.Diplome;
import com.lms.Application.entities.Filiere;
import com.lms.Application.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diplome")
@CrossOrigin(origins = "*")
public class ControleDiplome {
    @Autowired
    DiplomeService ds;
    @GetMapping("/getAll")
    public List<Diplome> getAll(){
        return ds.getAll();
    }
    @GetMapping("/filieres/{id}")
    public List<Filiere> getFilieres(@PathVariable("id") Long id){
        return ds.getFilieres(id);
    }
}
