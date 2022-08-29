package com.lms.Application.service;

import com.lms.Application.dao.AxeComponantRipository;
import com.lms.Application.dao.ElementRepository;
import com.lms.Application.dao.RessourceRepository;
import com.lms.Application.entities.AxeComponant;
import com.lms.Application.entities.Element;
import com.lms.Application.entities.Axe;
import com.lms.Application.entities.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class AxeService {
    @Autowired
    AxeComponantRipository ACR;
    @Autowired
    ElementRepository ER;
    @Autowired
    RessourceRepository ressourceRepository;

    public AxeComponant getAxe(Long id){
      return  ACR.findById(id).get();
    }
    public Axe addAxe(Axe ec , Long idAxe){
        ec=ACR.save(ec);
       AxeComponant a= ACR.findById(idAxe).get();
       a.addAxe(ec);
       return ec;
    }

    public void removeAxe(Long idAxe){
       AxeComponant ac=ACR.findById(idAxe).get();
       if(ac.getElement()!=null){
            ac.getElement().removeAxeComponant(ac);
       }
       ac.removeAllAxe();
       ac.removeRessources();
       ACR.deleteById(idAxe);
    }
    public void updateAxe(AxeComponant ac ){
        ACR.save(ac);
    }
    public List<Axe> getAxesById(Long id){
        return  ACR.findById(id).get().getSubAxes();
    }



    public Ressource addRessource(MultipartFile file , Long idAxe) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Ressource ec = new Ressource(fileName, file.getContentType(), file.getBytes());
        AxeComponant a= ACR.findById(idAxe).get();
        System.out.println("axe founded");
        a.addRessource(ec);
        ec=ressourceRepository.save(ec);
        System.out.println("ressource added");
        return ec;
    }
    public void removeRessource(String idRessources){
        Ressource ac=ressourceRepository.findById(idRessources).get();
        ac.getAxeComponant().removeRessource(ac);
        ac.setAxeComponant(null);
        ressourceRepository.deleteById(idRessources);
    }
    public Stream<Ressource> getRessourcesById(Long id){
        return  ACR.findById(id).get().getRessources().stream();
    }
    public void setContent(String content,Long id){
        AxeComponant a=ACR.findById(id).get();
        a.setContentHtml(content);
        ACR.save(a);

    }
}
