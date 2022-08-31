package com.lms.Application.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    @Id @GeneratedValue
    Long id;
    String anneeUniv= String.valueOf(LocalDate.now().getYear())+"/"+String.valueOf(LocalDate.now().getYear()+1);
    @ManyToOne
            @JsonIgnore
    Filiere filiere;
    @OneToMany(mappedBy = "promotion")
            @JsonIgnore
    List<Etudiant> etudiants=new ArrayList<Etudiant>();
    @OneToMany(mappedBy = "promotion")
    @JsonIgnore
    List<Niveau> niveaux= new ArrayList<Niveau>();
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return this.getId() != null && this.getId().equals(((Promotion) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
    public void addEtudiant(Etudiant m){
        m.setPromotion(this);
        this.etudiants.add(m);
    }
    public void removeEtudiant(Etudiant m){
        m.setPromotion(null);
        this.etudiants.remove(m);
    }
    public void removeEtudiants(){
        Iterator<Etudiant> iterator = this.etudiants.iterator();
        while (iterator.hasNext()) {
            Etudiant f = iterator.next();
            f.setPromotion(null);
            iterator.remove();
        }
    }
    public void addNiveau(Niveau m){
        m.setPromotion(this);
        this.niveaux.add(m);
    }
    public void removeNiveau(Niveau m){
        m.setPromotion(null);
        this.niveaux.remove(m);
    }
    public void removeNiveaux(){
        Iterator<Niveau> iterator = this.niveaux.iterator();
        while (iterator.hasNext()) {
            Niveau f = iterator.next();
            f.setPromotion(null);
            iterator.remove();
        }
    }
}
