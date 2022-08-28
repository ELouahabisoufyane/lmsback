package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ressource {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String lien;
    private String intitule;
    private String description;
    private Date dateEnLigne;
    private int numero;

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
