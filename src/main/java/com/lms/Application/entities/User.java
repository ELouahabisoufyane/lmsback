package com.lms.Application.entities;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 6)
public  class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Role> roles=new ArrayList<>();
    public void addRole(Role r){
        this.roles.add(r);
    }
    public void removeRole(Role r){
        this.roles.remove(r);
    }
    public void removeRoles(){

    }
}

