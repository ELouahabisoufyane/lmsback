package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ressource {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    URL url;
    String titre;
    @ManyToOne
    AxeComponant axeComponant;

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
        return this.getId() != null && this.getId().equals(((Ressource) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
