package com.lms.Application.entities;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class User implements Serializable {
    @Id
    @NotNull
    private Long id;
    private String username;
    private String email;
    private String password;
    @NotNull
    private boolean active = false;
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private Collection<UsersRoles> roles;

}

