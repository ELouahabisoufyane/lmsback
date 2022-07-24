package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
public class Professeur extends User{
    private String CNEP;

}
