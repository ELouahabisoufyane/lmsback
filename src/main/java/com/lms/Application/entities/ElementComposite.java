package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementComposite extends ElementComponant{
    @OneToMany(mappedBy = "elementComponant")
    List<ElementComponant> subElementComponant =new ArrayList<ElementComponant>();
    public void addElementComposite(ElementComposite p){
        p.setElementComponant(this);
        this.subElementComponant.add(p);
    }
    public void removeElementComposite(ElementComponant p){
        p.setElementComponant(this);
        this.subElementComponant.remove(p);
    }
    public void removeElementComposite(){
        Iterator<ElementComponant> iterator = this.subElementComponant.iterator();
        while (iterator.hasNext()) {
            ElementComponant f = iterator.next();
            f.setElementComponant(null);
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
        return this.getId() != null && this.getId().equals(((ElementComposite) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
