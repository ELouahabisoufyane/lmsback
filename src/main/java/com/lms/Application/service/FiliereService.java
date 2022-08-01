package com.lms.Application.service;

import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.NiveauRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.Filiere;
import com.lms.Application.entities.Niveau;
import com.lms.Application.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FiliereService {
    private final FiliereRepository fr;
    private final ProfesseurRepository pr;
    private final NiveauRepository nr;
    public FiliereService(FiliereRepository fr, ProfesseurRepository pr, NiveauRepository nr) {
        this.fr = fr;
        this.pr = pr;
        this.nr = nr;
    }


    public Filiere addFiliere(Filiere c,String n) {
        if(c.getId()==null ){
            c=fr.save(c);

            if(n.compareTo("pas")==0 ){
                Filiere f=fr.findById(c.getId()).get();

                f.setChefFiliere(null);


            }
            else{
            c.setprof(pr.findByUsername(n));}
             c=fr.save(c);
            if(c.getDeplome().compareTo("master")==0){
                c.addNiveau(nr.save(new Niveau(null,"1ére année",1,null)));

                c.addNiveau( nr.save(new Niveau(null,"2éme année",2,null)));}
            else if (c.getDeplome().compareTo("licence")==0) {
                c.addNiveau(nr.save(new Niveau(null,"1ére année",1,null)));
            }
            return fr.save(c);
        }
        else{

            if(n.compareTo("pas")==0 ){
                Filiere f=fr.findById(c.getId()).get();
                f.getChefFiliere().setMaFiliere(null);
                f.setChefFiliere(null);


            }
            else{
                c.setprof(pr.findByUsername(n));}
            return fr.save(c);

        }

    }





    public Page<Filiere> findPage(int pageNumber){

        return fr.findAll(PageRequest.of(pageNumber,6));
    }
    public Filiere findFilierebyId(Long id) {
        return fr.findById(id).get();
    }


    public Filiere updateFiliere(Filiere c) {
        return fr.save(c);

    }


    public void deleteFiliere(Long id) {
        Filiere f=fr.findById(id).get();
        List<Niveau> n=f.getNiveaux();
        for(Niveau nn:n){
            System.out.println(nn.getId());
            nr.deleteById(nn.getId());
        }
        f.removeNiveaux();
        f=fr.save(f);

        if(f.getChefFiliere()==null){
            fr.delete(f);
        }
        else{
            f.getChefFiliere().setMaFiliere(null);
            fr.delete(f);
        }



    }




    public Page<Filiere> chercherFiliere(String mc, int page, int size) {
        return fr.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }

    public Long getcard(){


        return fr.count();
    }

    public Professeur getChef(Filiere f){
        return f.getChefFiliere();
    }
    public Filiere updateChef(Filiere f,String n){

        f.updateprof(null);
        f.setprof(pr.findByUsername(n));
        return fr.save(f);
    }


}
