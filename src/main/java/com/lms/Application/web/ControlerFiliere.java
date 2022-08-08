package com.lms.Application.web;

import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.Filiere;
import com.lms.Application.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/filiere")
public class ControlerFiliere {
    @Autowired
    private final  FiliereService es;
    private final ProfesseurRepository pr;
    private final FiliereRepository fr;
    public ControlerFiliere(FiliereService es, ProfesseurRepository pr, FiliereRepository fr) {
        this.es = es;
        this.pr = pr;

        this.fr = fr;
    }
    @GetMapping("/list/{p}")
    public Page<Filiere> showPage(@PathVariable("p") int currentPage){
        Page<Filiere> page = es.findPage(currentPage);
        return page;
    }
    @PostMapping("/add/{name}")

    public Filiere addFiliere(@RequestBody Filiere cl,@PathVariable("name") String name) {
        Filiere newuser=es.addFiliere(cl,name);
        return newuser;
    }

    @PutMapping("/update")
    public Filiere updateFiliere(@RequestBody   Filiere u){

        return es.updateFiliere(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFiliere(@PathVariable("id")  Long id){

        es.deleteFiliere(id);
    }
    @GetMapping("/chercher")
    public  Page<Filiere> chercherFiliere(@RequestParam(name = "mc",defaultValue = "i") String mc,
                                            @RequestParam(name = "page",defaultValue = "0") int page,
                                            @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Filiere> p=es.chercherFiliere(mc,page,size) ;
        return p;
    }
    @GetMapping("/findbyid/{id}")
    public Filiere findFilierebyId(@PathVariable("id") Long id) {
       Filiere p=es.findFilierebyId(id);
        return p;
    }
    @GetMapping("/card")
    public Long card() {
        return  es.getcard();
    }
  @PostMapping("/addchef/{name}")
    public Filiere  addChef(@RequestBody Filiere cl,@PathVariable("name") String name) {
      return    es.updateChef(cl,name);
    }


}
