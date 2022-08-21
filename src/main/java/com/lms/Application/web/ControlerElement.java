package com.lms.Application.web;

import com.lms.Application.entities.Axe;
import com.lms.Application.entities.AxeComponant;
import com.lms.Application.entities.Element;
import com.lms.Application.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*" )
@RequestMapping("/element")
public class ControlerElement {
    @Autowired
    private final ElementService es;

    public ControlerElement(ElementService es) {
        this.es = es;
    }
    @PostMapping("/addElement/{idModule}/{idProf}")
    public Element addElement(@RequestBody  Element e,@PathVariable("idModule") Long idModule,@PathVariable("idProf") Long idProf){
        return es.addElement(e,idModule,idProf);
    }
    @PostMapping("/addAxe/{idElement}")
    public Axe addElement(@RequestBody  Axe e, @PathVariable("idElement") Long idElement){
       return es.addAxe(e,idElement);
    }
    @DeleteMapping("/removeElement/{id}")
    public void removeElement(@PathVariable("id") Long id){
        es.removeElement(id);
    }
    @GetMapping("/getElementsOfModule/{idmodule}")
    public List<Element> getElementsOfModule(@PathVariable("idmodule") Long idmodule){
        return es.getElementsByModule(idmodule);
    }
    @GetMapping("/getElement/{idElement}")
    public Element getElements(@PathVariable("idElement") Long idElement){
        return es.GetElement(idElement);
    }
    @GetMapping("/getAxesByElement/{idElement}")
    public List<Axe> getAxesByElement(@PathVariable("idElement") Long idElement){
        return es.GetAxesByElement(idElement);
    }
    @GetMapping("/getElementsOfProf/{idprof}")
    public List<Element> getElementsOfProf(@PathVariable("idprof") Long idprof){
        return es.getElementsByProf(idprof);
    }
}
