package com.lms.Application.web;
import com.lms.Application.entities.Axe;
import com.lms.Application.entities.AxeComponant;
import com.lms.Application.entities.Ressource;
import com.lms.Application.service.AxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins ="*" )
@RequestMapping("/Axe")
public class ControleAxe {
    @Autowired
    AxeService As;
    @PostMapping("/addAxe/{idAxe}")
    public AxeComponant addAxe(@RequestBody Axe ac, @PathVariable("idAxe")Long idAxe){
        return As.addAxe(ac,idAxe);
    }
    @GetMapping("/getOne/{idAxe}")
    public AxeComponant getAxe(@PathVariable("idAxe")Long idAxe){
        return As.getAxe(idAxe);
    }
    @DeleteMapping ("/DeleteOne/{idAxe}")
    public void removeAxe(@PathVariable("idAxe")Long idAxe){
         As.removeAxe(idAxe);
    }
    @PutMapping ("/updateOne")
    public void updateAxe(@RequestBody AxeComponant ac){
        As.updateAxe(ac);
    }
    @GetMapping("/getAxes/{idAxe}")
    public List<Axe> getAxesById(@PathVariable("idAxe")Long idAxe){
        return As.getAxesById(idAxe);
    }
    @GetMapping("/getRessources/{idAxe}")
    public List<Ressource> getRessourcesById(@PathVariable("idAxe")Long idAxe){
        return As.getRessourcesById(idAxe);
    }
}
