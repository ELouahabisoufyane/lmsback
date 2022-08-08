package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String titre;
<<<<<<< HEAD
=======
    String deplome="master";
    @JsonIgnore
    @OneToMany(mappedBy = "filiere")
    List<Niveau> niveaux=new ArrayList<>();
>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578

    @OneToOne(mappedBy = "maFiliere")
            @JsonIgnore
    Professeur chefFiliere;
<<<<<<< HEAD
    @ManyToOne
    @JsonIgnore
    Diplome diplome;
    @OneToMany(mappedBy = "filiere")
    @JsonIgnore
    List<Promotion> promotions =new ArrayList<Promotion>();
=======

>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578

    public void setprof(Professeur p){
    p.setMaFiliere(this);
    this.chefFiliere=p;
}
    public void updateprof(Professeur p){
        this.chefFiliere.setMaFiliere(null);
        this.chefFiliere=null;
    }
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

        return this.getId() != null && this.getId().equals(((Etudiant) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
    public void addPromotion(Promotion p){
        p.setFiliere(this);
        this.promotions.add(p);
    }
    public void removePromotion(Promotion p){
        p.setFiliere(this);
        this.promotions.remove(p);
    }
    public void removePromotions(){
        Iterator<Promotion> iterator = this.promotions.iterator();
        while (iterator.hasNext()) {
            Promotion f = iterator.next();
            f.setFiliere(null);
            iterator.remove();
        }
    }
}
