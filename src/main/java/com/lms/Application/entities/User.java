package com.lms.Application.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 6)
public  class User  {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Role> roles=new ArrayList<>();
    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    List<Annonce> annonces=new ArrayList<>();

    public void addAnnonce(Annonce a){
        a.setCreator(this);
        this.annonces.add(a);
    }
    public void removeAnnoce(Annonce a){
        a.setCreator(null);
        this.annonces.remove(a);
    }
    public void removeAnnonces(){
        Iterator<Annonce> iterator = this.annonces.iterator();
        while (iterator.hasNext()) {
            Annonce f = iterator.next();
            f.setCreator(null);
            iterator.remove();
        }
    }
    public void addRole(Role r){
        this.roles.add(r);
    }
    public void removeRole(Role r){
        this.roles.remove(r);
    }
    public void removeRoles(){

    }
}

