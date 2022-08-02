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
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String titre;
    int level;
    @JsonIgnore
    @ManyToOne
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
}
