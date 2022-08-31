package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
public class Element {
    @Id@GeneratedValue
    private Long id;
    private String name;
    @ManyToOne()  @JsonIgnore
    private Module module;
    @ManyToOne()@JsonIgnore
    private Professeur enseignant;
    @OneToMany(mappedBy = "element")
    @JsonIgnore
    List<Axe> subAxes=new ArrayList<Axe>();
    @OneToMany(mappedBy = "element")
            @JsonIgnore
    List<Annonce> annonces=new ArrayList<>();
    public void addAxeComponant(Axe p){
        p.setElement(this);
        this.subAxes.add(p);
    }
    public void removeAxeComponant(AxeComponant p){
        p.setElement(null);
        this.subAxes.remove(p);
    }
    public void removeAllAxeComponant(){
        Iterator<Axe> iterator = this.subAxes.iterator();
        while (iterator.hasNext()) {
            AxeComponant f = iterator.next();
            f.setAxe(null);
            iterator.remove();
        }
    }
    public void addAnnonce(Annonce a){
        a.setElement(this);
        this.annonces.add(a);
    }
    public void removeAnnoce(Annonce a){
        a.setElement(null);
        this.annonces.remove(a);
    }
    public void removeAnnonces(){
        Iterator<Annonce> iterator = this.annonces.iterator();
        while (iterator.hasNext()) {
            Annonce f = iterator.next();
            f.setElement(null);
            iterator.remove();
        }
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
        return this.getId() != null && this.getId().equals(((Element) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
