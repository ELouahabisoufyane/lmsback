package com.lms.Application.web;

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

    @DeleteMapping("/removeElement/{id}")
    public void removeElement(@PathVariable("id") Long id){
        es.removeElement(id);

    }
    @GetMapping("/getElementsOfModule/{idmodule}")
    public List<Element> getElementsOfModule(@PathVariable("idmodule") Long idmodule){
        return es.getElementsByModule(idmodule);
    }
    @GetMapping("/getElementsOfProf/{idprof}")
    public List<Element> getElementsOfProf(@PathVariable("idprof") Long idprof){
        return es.getElementsByProf(idprof);
    }
}
