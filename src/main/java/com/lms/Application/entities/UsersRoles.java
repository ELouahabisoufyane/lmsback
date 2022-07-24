package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersRoles implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="username")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")

    private Role role;
}
