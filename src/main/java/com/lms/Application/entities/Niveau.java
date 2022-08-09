package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String titre;
    int level;
    @JsonIgnore
    @ManyToOne

    Promotion promotion;
    @OneToMany(mappedBy = "niveau")
    List<Semestre> semestres= new ArrayList<Semestre>();
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

        return this.getId() != null && this.getId().equals(((Niveau) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }


    public void addSemestre(Semestre s){

        s.setNiveau(this);
        this.semestres.add(s);
    }
    public void removeSemestre(Semestre s){
        s.setNiveau(this);
        this.semestres.remove(s);
    }
    public void removeSemestres(){
        Iterator<Semestre> iterator = this.semestres.iterator();
        while (iterator.hasNext()) {
            Semestre f = iterator.next();
            f.setNiveau(null);
            iterator.remove();
        }
    }

}
