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
public class Semestre {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titre;
    int indece ;
    @ManyToOne
            @JsonIgnore
    Niveau niveau;
    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    List<Module> modules=new ArrayList<Module>();
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

        return this.getId() != null && this.getId().equals(((Semestre) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public void addModule(Module m){
        m.setSemestre(this);
        this.modules.add(m);
    }
    public void removeModule(Module m){
        m.setSemestre(null);
        this.modules.remove(m);
    }
    public void removeSemestres(){
        Iterator<Module> iterator = this.modules.iterator();
        while (iterator.hasNext()) {
            Module f = iterator.next();
            f.setSemestre(null);
            iterator.remove();
        }
    }

}
