package com.lms.Application.service;

import com.lms.Application.dao.ModuleRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.dao.SemestreRepository;
import com.lms.Application.entities.*;
import com.lms.Application.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class SemestreService {
    private final SemestreRepository sr;
    @Autowired
    ModuleRepository mr;
    @Autowired
    ProfesseurRepository pr;
    public SemestreService(SemestreRepository sr) {
        this.sr = sr;
    }

    public Page<Module> findPageModules(Long id,int pageNumber){

        return sr.findAllModules(id,PageRequest.of(pageNumber,3));
    }

    public void CloneModules(Semestre clone,Semestre origin) {

        for (Module m:origin.getModules()){
            Module m1=new Module();
            m1.setTitre(m.getTitre());
            m1=mr.save(m1);
            if(m.getProfesseur()!=null)
                m.getProfesseur().addModule(m1);
            clone.addModule(m1);
        }
        };
    public void retirerModules(Long id){
                Module m=mr.findById(id).get();
                 m.getSemestre().removeModule(m);
                if(m.getProfesseur()!=null)
                 m.getProfesseur().removeModule(m);
                mr.delete(m);
    }
    public Module addModule(Long ids,Module m,Long idp){
        m=mr.save(m);
        Semestre s=sr.findById(ids).get();
        s.addModule(m);
        if(idp!=-1){
            Professeur p=pr.findById(idp).get();
            p.addModule(m);
        }
        return m;
    }
}

