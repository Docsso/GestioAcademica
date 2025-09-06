package com.example.gestionacademica.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Profesor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String nombre;

    @Column(nullable=false, unique=true, length=150)
    private String email;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos = new ArrayList<>();

    public Profesor(){}

    public Profesor(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public List<Curso> getCursos(){ return cursos; }
    public void setCursos(List<Curso> cursos){ this.cursos = cursos; }
}
