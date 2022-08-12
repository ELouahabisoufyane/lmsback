package com.lms.Application.web;

import com.lms.Application.entities.Module;
import com.lms.Application.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Semestre")
public class ControleSemestre {
    @Autowired
    SemestreService ss;
    @DeleteMapping("/deleteModule/{id}")
    public void RetirerModule(@PathVariable("id") Long id){
        ss.retirerModules(id);
    }
    @PostMapping("/addModule/{ids}/{idp}")
    public void addModule(@PathVariable("ids") Long ids,@RequestBody Module m,@PathVariable("idp") Long idp){
        ss.addModule(ids,m,idp);
    }

}
