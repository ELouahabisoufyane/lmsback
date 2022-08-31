package com.lms.Application.service;

import com.lms.Application.dao.AnnonceRepository;
import com.lms.Application.dao.ElementRepository;
import com.lms.Application.dao.UserRepository;
import com.lms.Application.entities.*;
import com.lms.Application.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository AR;
    @Autowired
    ElementRepository ER;
    @Autowired
    UserRepository UR;

    public Annonce addAnnonce(Annonce a,Long idElement, Long idUser){
        Element e=ER.findById(idElement).get();
        System.out.println("2   "+e.getId());
        User u=UR.findById(idUser).get();
        System.out.println("3    "+u.getId());
        a =AR.save(a);
        System.out.println("4     "+a.getId());
        e.addAnnonce(a);
        System.out.println("5");
        u.addAnnonce(a);
        System.out.println("6");
        return AR.save(a);
    }
    public Annonce GetAnnonce(Long idAnnonce){
        return AR.findById(idAnnonce).get();
    }
    public void removeAnnonce(Long id){
        Annonce  a=AR.findById(id).get();
        a.getCreator().removeAnnoce(a);
        a.getElement().removeAnnoce(a);
        AR.delete(a);
    }

    public List<Annonce> getAnnoncesByElement(Long idElement ){
        Element e=ER.findById(idElement).get();
        System.out.println(e.getId());
        System.out.println(e.getAnnonces().get(0).getId());
        return e.getAnnonces();
    }
    public List<Annonce> getAnnoncesByUser(Long idUser ){
        User u=UR.findById(idUser).get();
        return u.getAnnonces();
    }

}
