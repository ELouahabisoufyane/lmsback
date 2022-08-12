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
    private final SemestreService ss;
    public FiliereService(FiliereRepository fr, ProfesseurRepository pr, PromotionRepository pr1, PromotionRepository promr, NiveauRepository nr, SemestreRepository sr, SemestreService ss) {
        this.fr = fr;
        this.profr = pr;
        this.promr = promr;

        this.nr = nr;
        this.sr = sr;
        this.ss = ss;
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
    private Niveau GenerateNiveau(String titre,int level){
        Niveau n=new Niveau();
        n.setTitre(titre);
        n.setLevel(level);
        n=nr.save(n);
        for (int i=1;i<=2;i++){
        n.addSemestre(GenerateSmestre(i));
        }
        return n;
    }

    private Semestre GenerateSmestre(int indece) {
        Semestre s=new Semestre();
        s.setTitre("Semestre "+indece);
        s.setIndece(indece);
        return sr.save(s);
    }

    public Filiere addPromotion(Long idF){
        int i=0;
         Filiere f=fr.findById(idF).get();
         Promotion p=new Promotion();
         p=promr.save(p);
        if(f.getDiplome().getIndece()==1){
            Niveau n=GenerateNiveau("premiere annee",1);
            if(f.getPromotions().get(0)!=null){
            for (Semestre s:n.getSemestres()) {
                ss.CloneModules(s,f.getPromotions().get(0).getNiveaux().get(0).getSemestres().get(i));
                i++;
            }
            i=0;}
        }else if(f.getDiplome().getIndece()==2){
            Niveau n1=GenerateNiveau("premiere annee",1);
            if(f.getPromotions().get(0)!=null){
            for (Semestre s:n1.getSemestres()) {
                ss.CloneModules(s,f.getPromotions().get(0).getNiveaux().get(0).getSemestres().get(i));
                i++;
            }
            i=0;}
            p.addNiveau(n1);

            Niveau n2=GenerateNiveau("deuxieme annee",2);
            if(f.getPromotions().get(0)!=null){
            for (Semestre s:n2.getSemestres()) {
                ss.CloneModules(s,f.getPromotions().get(0).getNiveaux().get(1).getSemestres().get(i));
                i++;
            }}
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
