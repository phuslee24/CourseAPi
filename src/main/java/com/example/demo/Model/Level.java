package com.example.demo.Model;


import java.lang.reflect.Constructor;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "level")
public class Level extends BaseModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sign")
    private String sign;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private Set<Course> course;

    public Level(int Id, String Sign, String Name){
        this.id = Id;
        this.sign = Sign;
        this.name = Name;
    }
}
