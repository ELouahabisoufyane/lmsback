package com.lms.Application.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annonce {
    @Id @GeneratedValue
    Long id;
    String contentHtml;
    String date=LocalDate.now().toString();
    @ManyToOne()
    User creator;
    @ManyToOne()
    @JsonIgnore
    Element element;
}
