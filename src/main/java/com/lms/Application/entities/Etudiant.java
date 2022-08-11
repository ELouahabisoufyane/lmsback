package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@DiscriminatorValue("ETD")
public class Etudiant extends User{

    @ManyToOne()
    @JsonIgnore
    Promotion promotion;
    @OneToMany(mappedBy = "etudiant")@JsonIgnore
    List<Inscription> inscriptions=new ArrayList<Inscription>();

    private boolean selec=false;
    private String cne;



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








    public void addInscription(Inscription i){
        i.setEtudiant(this);
        this.inscriptions.add(i);
    }
    public void removeInscription(Inscription i){
        i.setEtudiant(this);
        this.inscriptions.remove(i);
    }
    public void removeInscription(){
        Iterator<Inscription> iterator = this.inscriptions.iterator();
        while (iterator.hasNext()) {
            Inscription f = iterator.next();
            f.setEtudiant(null);
            iterator.remove();
        }
    }
}
