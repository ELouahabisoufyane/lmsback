package com.lms.Application.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable
{
    @Id
    @NotNull
    @GeneratedValue
    Long id;

    //@Size(min=3,max=100)
    private String role;

}
