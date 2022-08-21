package com.lms.Application.service;
import com.lms.Application.dao.AxeComponantRipository;
import com.lms.Application.dao.ElementRepository;
import com.lms.Application.dao.ModuleRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.*;
import com.lms.Application.entities.Module;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ElementService {
    private final ElementRepository er;
    private final ModuleRepository mr;
    private final ProfesseurRepository pr;
    private final AxeComponantRipository ECR;
    public ElementService(ElementRepository er, ModuleRepository mr, ProfesseurRepository pr, AxeComponantRipository ecr) {
        this.er = er;
        this.mr = mr;
        this.pr = pr;
        ECR = ecr;
    }
    public Element addElement(Element e,Long idModule,Long idprof){
        Module m=mr.findById(idModule).get();
        e=er.save(e);
        m.addElement(e);
        Professeur p=pr.findById(idprof).get();
        p.addElement(e);
        return e;
    }
    public Element GetElement(Long idElement){
        return er.findById(idElement).get();
    }

    public void removeElement(Long id){
        Element  e=er.findById(id).get();
        e.getModule().removeElement(e);
        if(e.getEnseignant()!=null){
            e.getEnseignant().removeElement(e);
            er.delete(e);}
        else{
            er.delete(e);
        }
    }
    public List<Element> getElementsByModule(Long idModule ){
        Module m=mr.findById(idModule).get();
        return m.getElements();
    }
    public List<Element> getElementsByProf(Long idProf ){
        Professeur p=pr.findById(idProf).get();
        return p.getElements();
    }
    public Axe addAxe(Axe ec, Long idElement){
        ec = ECR.save(ec);
        Element e=er.findById(idElement).get();
        e.addAxeComponant(ec);
        return ec;
    }
    public List<Axe> GetAxesByElement(Long idElement){
        return er.findById(idElement).get().getSubAxes();
    }
}
