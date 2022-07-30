package com.lms.Application.web;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import com.lms.Application.entities.User;
import com.lms.Application.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prof")
@CrossOrigin(origins ="*" )
public class ControlerProf {
    @Autowired
    private final ProfService ps;

    public ControlerProf(ProfService ps) {
        this.ps = ps;
    }

    @GetMapping("/list/{p}")
    public Page<Professeur> showPage(@PathVariable("p") int currentPage){
        Page<Professeur> page = ps.findPage(currentPage);
        return page;
    }
    @PostMapping("/add/{role}")

    public Professeur addProfesseur(@RequestBody Professeur cl,@PathVariable("role") String role) {
        Professeur newuser=ps.addProfesseur(cl,role);
        return newuser;
    }

    @PutMapping("/update")
    public Professeur updateProfesseur(@RequestBody   Professeur u){

        return ps.updateProfesseur(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProfesseur(@PathVariable("id")  Long id){
        ps.deleteProfesseur(id);
    }
    @GetMapping("/chercher")
    public  Page<Professeur> chercherprof(@RequestParam(name = "mc",defaultValue = "i") String mc,
                                       @RequestParam(name = "page",defaultValue = "0") int page,
                                       @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Professeur> p=ps.chercherProf(mc,page,size) ;

        return p;
    }
    @GetMapping("/findbyid/{id}")
    public Professeur findProfbyId(@PathVariable("id") Long id) {
        Professeur p=ps.findProfbyId(id);
        return p;
    }
    @GetMapping("/card")
    public Long card() {
        return  ps.getcard();

    }
    @GetMapping("/all")
    public List<Professeur> getProfs() {

        return  ps.getProfs();

    }
}
