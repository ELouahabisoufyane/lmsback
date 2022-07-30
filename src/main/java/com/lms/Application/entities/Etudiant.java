package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@DiscriminatorValue("ETD")
public class Etudiant extends User{

    private String CNE;
    @ManyToOne()
    Filiere filiere;


}
