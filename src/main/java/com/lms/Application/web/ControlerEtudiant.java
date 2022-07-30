package com.lms.Application.web;

import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Etudiant;
import com.lms.Application.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin(origins ="*" )
public class ControlerEtudiant {
    @Autowired
    private final EtudiantService es;
    @Autowired
    private final RoleRepository r;
    public ControlerEtudiant(EtudiantService es, RoleRepository r) {
        this.es = es;
        this.r = r;
    }


    @GetMapping("/list/{p}")
    public Page<Etudiant> showPage(@PathVariable("p") int currentPage){
        Page<Etudiant> page = es.findPage(currentPage);
        return page;
    }
    @PostMapping("/add/{role}")

    public Etudiant addEtudiant(@RequestBody Etudiant cl,@PathVariable("role") String role) {
        Etudiant newuser=es.addEtudiant(cl,role);
        return newuser;
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody   Etudiant u){

        return es.updateEtudiant(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id")  Long id){

        es.deleteEtudiant(id);
    }
    @GetMapping("/chercher")
    public  Page<Etudiant> chercherEtudiant(@RequestParam(name = "mc",defaultValue = "i") String mc,
                                          @RequestParam(name = "page",defaultValue = "0") int page,
                                          @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Etudiant> p=es.chercherEtudiant(mc,page,size) ;

        return p;
    }
    @GetMapping("/findbyid/{id}")
    public Etudiant findEtudiantbyId(@PathVariable("id") Long id) {
        Etudiant p=es.findEtudiantbyId(id);
        return p;
    }
    @GetMapping("/card")
    public Long card() {
        return  es.getcard();

    }




}
