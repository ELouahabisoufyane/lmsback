package com.lms.Application.web;

import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.Filiere;
import com.lms.Application.entities.Niveau;
import com.lms.Application.entities.Promotion;
import com.lms.Application.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


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
    @GetMapping("/getAll")
    public List<Filiere> getAll(){
        return fr.findAll();
    }
    @PostMapping("/add/{idProf}/{idDiplome}")
    public Filiere addFiliere(@RequestBody Filiere cl,@PathVariable("idProf") Long idProf,@PathVariable("idDiplome") Long idDiplome) {
        Filiere newuser=es.addFiliere(cl,idProf,idDiplome);
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
  @PostMapping("/addchef/{id}")
    public Filiere  addChef(@RequestBody Filiere cl,@PathVariable("id") Long id) {
      return    es.updateChef(cl,id);
    }
  @GetMapping("/Promotions/{id}")
    List<Promotion> GetPromotions(@PathVariable("id")Long id){
       return es.getPromotions(id);
  }
    @GetMapping("/addPromo/{id}")
    Filiere addPromo(@PathVariable("id")Long id){
        return es.addPromotion(id);
    }

}
