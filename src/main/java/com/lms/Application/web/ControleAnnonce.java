package com.lms.Application.web;

import com.lms.Application.entities.Annonce;
import com.lms.Application.entities.Element;
import com.lms.Application.entities.User;
import com.lms.Application.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/Annonce")
@CrossOrigin(origins ="*" )
public class ControleAnnonce {
    @Autowired
    AnnonceService AS;

    @PostMapping("/addAnnonce/{idElement}/{idUser}")
    public Annonce addAnnonce(@RequestBody  Annonce a, @PathVariable("idElement") Long idElement,@PathVariable("idUser") Long idUser){
        System.out.println("1");
        return AS.addAnnonce(a,idElement,idUser);
    }
    @GetMapping("/getAnnonce/{idAnnonce}")
    public Annonce GetAnnonce(@PathVariable("idAnnonce") Long idAnnonce){
       return AS.GetAnnonce(idAnnonce);
    }
    @DeleteMapping("/deleteAnnonce/{idAnnonce}")
    public void removeAnnonce(@PathVariable("idAnnonce") Long id){
         AS.removeAnnonce(id);
    }

    @GetMapping("/getByElement/{idElement}")
    public List<Annonce> getAnnoncesByElement(@PathVariable("idElement") Long idElement ){
        System.out.println("ok");
          return AS.getAnnoncesByElement(idElement);
    }

    @GetMapping("/getByUser/{idUser}")
    public List<Annonce> getAnnoncesByUser(@PathVariable("idUser") Long idUser ){
        return AS.getAnnoncesByUser(idUser);
    }

}
