package com.lms.Application.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ElementComponant {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     Long id ;
     String Titre ;
     String Description ;
     String ContentHtml ;
     @ManyToOne
     @JsonIgnore
     ElementComponant elementComponant;
     @OneToMany(mappedBy = "elementComponant")
     List<Ressource> ressources =new ArrayList<Ressource>();

     public void addRessource(Ressource p){

          p.setElementComponant(this);
          this.ressources.add(p);
     }
     public void removeRessource(Ressource p){
          p.setElementComponant(this);
          this.ressources.remove(p);
     }
     public void removeRessources(){
          Iterator<Ressource> iterator = this.ressources.iterator();
          while (iterator.hasNext()) {
               Ressource f = iterator.next();
               f.setElementComponant(null);
               iterator.remove();
          }
     }
}
