package com.lms.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files")
public class Ressource {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    public Ressource(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
    @ManyToOne
            @JsonIgnore
    AxeComponant axeComponant;

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.getId() != null && this.getId().equals(((Ressource) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
