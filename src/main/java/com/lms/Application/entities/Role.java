package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable
{
    @Id
    @GeneratedValue
    Long id;
    private String role;
    @ManyToMany(mappedBy = "roles")
            @JsonIgnore
    List<User> user;


}
