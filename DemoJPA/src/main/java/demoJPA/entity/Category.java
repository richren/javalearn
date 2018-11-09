package demoJPA.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Category")
@Data
public class Category implements Serializable {
    @Override
    public String toString() {
        return "id="+id+" name="+name;
    }
    @Id
    private Integer id;
    private  String name;
}