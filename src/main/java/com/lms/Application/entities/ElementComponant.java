package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class ElementComponant {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     Long id ;
     String Titre ;
     String Description ;
     String ContentHtml ;

     @ManyToOne
     @JsonIgnore
     ElementComponant elementComponant;

}
