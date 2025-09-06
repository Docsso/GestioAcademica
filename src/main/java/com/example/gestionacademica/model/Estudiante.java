package com.example.gestionacademica.model;

import jakarta.persistence.*;

@Entity
public class Estudiante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=20)
    private String carne;

    @Column(nullable=false, length=120)
    private String nombres;

    @Column(nullable=false, length=120)
    private String apellidos;

    @Column(nullable=false, unique=true, length=150)
    private String email;

    public Estudiante(){}

    public Estudiante(String carne, String nombres, String apellidos, String email){
        this.carne = carne;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getCarne(){ return carne; }
    public void setCarne(String carne){ this.carne = carne; }
    public String getNombres(){ return nombres; }
    public void setNombres(String nombres){ this.nombres = nombres; }
    public String getApellidos(){ return apellidos; }
    public void setApellidos(String apellidos){ this.apellidos = apellidos; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
}
