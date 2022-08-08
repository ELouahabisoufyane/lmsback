package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
=======
import java.util.*;
>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578

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
<<<<<<< HEAD
    Promotion promotion;
    @OneToMany(mappedBy = "niveau")
    @JsonIgnore
    List<Semestre> semestres= new ArrayList<Semestre>();
=======
    Filiere filiere;
    @OneToMany(mappedBy = "niveau")
    @JsonIgnore
    private Set<Etudiant>  students=new HashSet<Etudiant>();
    public void addStudent(Etudiant s){
        s.setNiveau(this);
        this.students.add(s);
    }
    public void removeStudent(Etudiant s){
        s.setNiveau(null);
        this.students.remove(s);
    }
    public  void removeStudents(){
        Iterator<Etudiant> iterator = this.students.iterator();
        while (iterator.hasNext()) {
            Etudiant std = iterator.next();
            std.setNiveau(null);
            iterator.remove();
        }
    }
    public List<Etudiant> getDemandeStudent(){
        List<Etudiant> l= new ArrayList<Etudiant>();
        for(Etudiant s:this.getStudents()){
            if (s.getEtat()==0)
                l.add(s);
        }
        return l;
    }
    public List<Etudiant> getAffecteStudent(){
        List<Etudiant> l= new ArrayList<Etudiant>();
        for(Etudiant s:this.getStudents()){
            if (s.getEtat()==1)
                l.add(s);
        }
        return l;
    }
    public  List<Etudiant> getExlcusedStudent(){
        List<Etudiant> l= new ArrayList<Etudiant>();
        for(Etudiant s:this.getStudents()){
            if (s.getEtat()==-1)
                l.add(s);
        }
        return l;
    }
    @Override
>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578
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
<<<<<<< HEAD

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
=======
>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578
}
