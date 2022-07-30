package com.lms.Application.web;
import com.lms.Application.entities.Classe;
import com.lms.Application.service.ClasseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
@CrossOrigin(origins = "*")

public class ControlerClasse {

    private final ClasseService cs;

    public ControlerClasse(ClasseService cs) {
        this.cs = cs;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Classe>> getAllClasses () {
        List<Classe> classes=cs.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Classe> addClass(@RequestBody  Classe cl) {
        Classe newclasse=cs.addClass(cl);
        return new ResponseEntity<>(newclasse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Classe> updateClass(@RequestBody Classe c) {
        Classe updateclasse=cs.addClass(c);
        return new ResponseEntity<>(updateclasse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteClass(@PathVariable("id") Long id) {
        cs.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/chercher")
    public  Page<Classe> chercherClass(@RequestParam(name = "mc",defaultValue = "i") String mc,
                                               @RequestParam(name = "page",defaultValue = "0") int page,
                                               @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Classe> p=cs.chercherClass(mc,page,size) ;

        return p;
    }
    @GetMapping("/list/{p}")
    public  Page<Classe> showPage(@PathVariable("p") int currentPage){
        Page<Classe> page = cs.findPage(currentPage);
        return page;
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Classe> findClassbyId(@PathVariable("id") Long id) {
        Classe classe=cs.findClassbyId(id);
        return new ResponseEntity<>(classe, HttpStatus.OK);
    }

}
