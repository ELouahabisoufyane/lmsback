package com.lms.Application.entities;

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

    String deplome="master";
    String titre;
    @OneToMany(mappedBy = "filiere")
    List<Niveau> niveaux=new ArrayList<>();

    @OneToOne(mappedBy = "maFiliere")
    Professeur chefFiliere;
    @OneToMany(mappedBy = "filiere")
    Set<Etudiant> students=new HashSet<Etudiant>();

    public void setprof(Professeur p){
    p.setMaFiliere(this);
    this.chefFiliere=p;
}
    public void updateprof(Professeur p){
        this.chefFiliere.setMaFiliere(null);
        this.chefFiliere=null;
    }
    public void addNiveau(Niveau n){
        n.setFiliere(this);
        niveaux.add(n);
    }

    public void removeNiveaux(){
        Iterator<Niveau> iterator = this.niveaux.iterator();
        while (iterator.hasNext()) {
            Niveau f = iterator.next();
            f.setFiliere(null);
            iterator.remove();
            }
        }


}
