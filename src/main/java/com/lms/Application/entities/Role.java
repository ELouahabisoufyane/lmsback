package com.lms.Application.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable
{
    @Id
    @NotNull
    @GeneratedValue
    Long id;
    private String role;


}
