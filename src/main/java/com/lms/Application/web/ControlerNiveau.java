package com.lms.Application.web;

import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Niveau;
import com.lms.Application.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/niveau")
public class ControlerNiveau {
    @Autowired
    private final NiveauService ns;
    public ControlerNiveau(NiveauService ns) {
        this.ns = ns;
    }
    @GetMapping("/findbyid/{id}")
    public Niveau findEtudiantbyId(@PathVariable("id") Long id) {
        return ns.findEtudiantbyId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNiveau(@PathVariable("id")  Long id) {
        ns.deleteNiveau(id);
    }
    @PostMapping("/add")
    public Niveau addNiveau(Niveau c) {
        return ns.addNiveau(c);
    }
    @GetMapping("/all")
    public List<Niveau> getNiveaux() {
        return ns.getNiveaux();
    }




}
