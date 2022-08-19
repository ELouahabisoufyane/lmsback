package com.lms.Application.service;

import com.lms.Application.dao.AxeComponantRipository;
import com.lms.Application.dao.ElementRepository;
import com.lms.Application.entities.AxeComponant;
import com.lms.Application.entities.Element;
import com.lms.Application.entities.Axe;
import com.lms.Application.entities.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AxeService {
    @Autowired
    AxeComponantRipository ACR;
    @Autowired
    ElementRepository ER;

    public AxeComponant getAxe(Long id){
      return  ACR.findById(id).get();
    }
    public AxeComponant addAxe(AxeComponant ec , Long idAxe){
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
    }
    public void updateAxe(AxeComponant ac ){
        ACR.save(ac);
    }
    public List<AxeComponant> getAxesById(Long id){
        return  ACR.findById(id).get().getSubAxes();
    }
    public List<Ressource> getRessourcesById(Long id){
        return  ACR.findById(id).get().getRessources();
    }

}
