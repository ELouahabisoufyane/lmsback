package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Module implements Cloneable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titre;

    @ManyToOne
    @JsonIgnore
    Semestre semestre;
    @ManyToOne()
    Professeur professeur;
    @OneToMany(mappedBy = "module")
    @JsonIgnore
    List<Inscription> inscrits=new ArrayList<Inscription>();

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

        return this.getId() != null && this.getId().equals(((Module) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public void addInscription(Inscription i){
        i.setModule(this);
        this.inscrits.add(i);
    }
    public void removeInscription(Inscription i){
        i.setModule(this);
        this.inscrits.remove(i);
    }
    public void removeInscriptions(){
        Iterator<Inscription> iterator = this.inscrits.iterator();
        while (iterator.hasNext()) {
            Inscription f = iterator.next();
            f.setEtudiant(null);
            iterator.remove();
        }
    }
    @Override
    public Object clone()throws CloneNotSupportedException{

        return super.clone();
    }
}
