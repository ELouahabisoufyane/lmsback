package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Axe extends AxeComponant {
    @OneToMany(mappedBy = "axe")
    List<AxeComponant> subAxes =new ArrayList<AxeComponant>();
    public void addAxe(AxeComponant p){
        p.setAxe(this);
        this.subAxes.add(p);
    }
    public void removeAxe(AxeComponant p){
        p.setAxe(null);
        this.subAxes.remove(p);
    }
    public void removeAllAxe(){
        Iterator<AxeComponant> iterator = this.subAxes.iterator();
        while (iterator.hasNext()) {
            AxeComponant f = iterator.next();
            f.setAxe(null);
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
        return this.getId() != null && this.getId().equals(((Axe) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

}
