package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementComposite extends ElementComponant{


    @OneToMany(mappedBy = "elementComponant")
    List<ElementComponant> subElementComponant =new ArrayList<ElementComponant>();



}
