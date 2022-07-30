package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@DiscriminatorValue("PROF")
public class Professeur extends User{
    private String CNEP;
@JsonIgnore
    @OneToOne
    Filiere maFiliere;
}
