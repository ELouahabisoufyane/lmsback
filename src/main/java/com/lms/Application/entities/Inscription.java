package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String anneeUniv= String.valueOf(LocalDate.now().getYear())+"/"+String.valueOf(LocalDate.now().getYear())+1;
    int score;

    @ManyToOne
    @JsonIgnore
    Module module;
    @ManyToOne
    @JsonIgnore
    Etudiant etudiant;


}
