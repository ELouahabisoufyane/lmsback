package com.lms.Application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
@DiscriminatorValue("ADM")
public class Admin extends User{
    private String CNEA;
}
