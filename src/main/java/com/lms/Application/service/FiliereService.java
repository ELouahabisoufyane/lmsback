package com.lms.Application.service;

import com.lms.Application.dao.*;
import com.lms.Application.entities.*;
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
    private final ProfesseurRepository profr;
    private final PromotionRepository promr;
    private final NiveauRepository nr;
    private final SemestreRepository sr;
    public FiliereService(FiliereRepository fr, ProfesseurRepository pr, PromotionRepository pr1, PromotionRepository promr, NiveauRepository nr, SemestreRepository sr) {
        this.fr = fr;
        this.profr = pr;
        this.promr = promr;

        this.nr = nr;
        this.sr = sr;
    }
    public Filiere addFiliere(Filiere c,Long idProf) {
      if(c.getId()==null ){
            c=fr.save(c);
            if(idProf==-1 ){
                Filiere f=fr.findById(c.getId()).get();
                f.setChefFiliere(null);
            }
            else{
            c.setprof(profr.findById(idProf).get());}
             //c=fr.save(c);
            return fr.save(c);
        }
        else{
            if(idProf==-1 ){
                Filiere f=fr.findById(c.getId()).get();
                f.getChefFiliere().setMaFiliere(null);
                f.setChefFiliere(null);
            }
            else{
                c.setprof(profr.findById(idProf).get());}
            return fr.save(c);
        }
       // return null;
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
        List<Promotion> n=f.getPromotions();
        for(Promotion nn:n){
            System.out.println(nn.getId());
            nr.deleteById(nn.getId());
        }
        f.removePromotions();
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
    public Filiere updateChef(Filiere f,Long id){
        f.resetProf();
        f.setprof(profr.findById(id).get());
        return fr.save(f);
    }
    public List<Promotion> getPromotions(Long id){
        Filiere f=fr.findById(id).get();
        return f.getPromotions();
    }
    public Filiere addPromotion(Long idF){
         Filiere f=fr.findById(idF).get();
         Promotion p=new Promotion();
         p=promr.save(p);
        if(f.getDiplome().getIndece()==1){
            Niveau n=new Niveau();
            n.setTitre("premiere annee");
            n.setLevel(1);
            n=nr.save(n);
            Semestre s1=new Semestre();
            s1.setTitre("Semestre 1");
            s1.setIndece(1);
            s1=sr.save(s1);
            Semestre s2=new Semestre();
            s2.setTitre("Semestre 2");
            s2.setIndece(2);
            s2=sr.save(s2);
            n.addSemestre(s1);
            n.addSemestre(s2);
            p.addNiveau(n);
        }else if(f.getDiplome().getIndece()==2){
            Niveau n=new Niveau();
            n.setTitre("premiere annee");
            n.setLevel(1);
            n=nr.save(n);
            Semestre s1=new Semestre();
            s1.setTitre("Semestre 1");
            s1.setIndece(1);
            s1=sr.save(s1);
            Semestre s2=new Semestre();
            s2.setTitre("Semestre 2");
            s2.setIndece(2);
            s2=sr.save(s2);
            n.addSemestre(s1);
            n.addSemestre(s2);
            Niveau n2=new Niveau();
            n2.setTitre("deuxieme annee");
            n2.setLevel(2);
            n2=nr.save(n2);
            Semestre s3=new Semestre();
            s3.setTitre("Semestre 1");
            s3.setIndece(1);
            s3=sr.save(s3);
            Semestre s4=new Semestre();
            s4.setTitre("Semestre 2");
            s4.setIndece(2);
            s4=sr.save(s4);
            n2.addSemestre(s3);
            n2.addSemestre(s4);
            p.addNiveau(n);
            p.addNiveau(n2);
        }
         f.addPromotion(p);
        return f;
    }
    public void addEtudiant(Etudiant e,Long idFiliere){
        Filiere f=fr.findById(idFiliere).get();
        f.getPromotions().get(0).addEtudiant(e);
    }
}
