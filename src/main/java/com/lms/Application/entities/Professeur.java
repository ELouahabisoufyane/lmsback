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
@DiscriminatorValue("PROF")
public class Professeur extends User{
    private String cin;
    @JsonIgnore
    @OneToOne
    Filiere maFiliere;
    @OneToMany(mappedBy = "professeur",fetch = FetchType.EAGER)
    @JsonIgnore
    List<Module> modules=new ArrayList<Module>();
    @OneToMany(mappedBy = "enseignant",fetch = FetchType.LAZY)
    private List<Element> elements=new ArrayList<>();
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
        return this.getId() != null && this.getId().equals(((Professeur) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
    public void addModule(Module m){
        m.setProfesseur(this);
        this.modules.add(m);
    }
    public void removeModule(Module m){
        m.setProfesseur(null);
        this.modules.remove(m);
    }
    public void removeModules(){
        Iterator<Module> iterator = this.modules.iterator();
        while (iterator.hasNext()) {
            Module f = iterator.next();
            f.setProfesseur(null);
            iterator.remove();
        }
    }

    public void addElement(Element e) {
        e.setEnseignant(this);
        this.elements.add(e);
    }

    public void removeElement(Element e) {
        e.setEnseignant(null);
        elements.remove(e);
    }
}
