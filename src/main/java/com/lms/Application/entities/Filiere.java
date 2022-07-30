package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    Set<Niveau> niveaus=new HashSet<Niveau>(); ;

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

}
