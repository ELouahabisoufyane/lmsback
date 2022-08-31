package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diplome {

    @Id @GeneratedValue
    Long id;
    String typeDiplome;
    int indece;
    @OneToMany(mappedBy = "diplome")
    @JsonIgnore
    List<Filiere> filieres= new ArrayList<Filiere>();

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

        return this.getId() != null && this.getId().equals(((Diplome) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public void addFiliere(Filiere f){
        f.setDiplome(this);
        this.filieres.add(f);
    }
    public void removeFiliere(Filiere f){
        f.setDiplome(null);
        this.filieres.remove(f);
    }
    public void removeFilieres(){
        Iterator<Filiere> iterator = this.filieres.iterator();
        while (iterator.hasNext()) {
            Filiere f = iterator.next();
            f.setDiplome(null);
            iterator.remove();
        }
    }

}
