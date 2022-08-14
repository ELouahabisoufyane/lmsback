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
    @PostMapping("/addDiplome")
    public Diplome addOne(@RequestBody Diplome d){
       return ds.add(d);
    }
    @PutMapping("/updateDiplome")
    public void updateOne(@RequestBody Diplome d){
        ds.update(d);
    }
    @DeleteMapping("/deleteDiplome/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        ds.remove(id);
    }
    @GetMapping("/getDiplome/{id}")
    public void getOne(@PathVariable("id") Long id){
        ds.getOne(id);
    }
    @GetMapping("/getAll")
    public List<Diplome> getAll(){
        return ds.getAll();
    }
    @GetMapping("/filieres/{id}")
    public List<Filiere> getFilieres(@PathVariable("id") Long id){
        return ds.getFilieres(id);
    }
}
