package com.example.gestionacademica.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Inscripcion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="estudiante_id")
    private Estudiante estudiante;

    @ManyToOne(optional=false)
    @JoinColumn(name="curso_id")
    private Curso curso;

    private LocalDate fechaInscripcion = LocalDate.now();

    @Column(length=30)
    private String estado = "ACTIVA";

    public Inscripcion(){}

    public Inscripcion(Estudiante estudiante, Curso curso, LocalDate fechaInscripcion, String estado){
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public Estudiante getEstudiante(){ return estudiante; }
    public void setEstudiante(Estudiante estudiante){ this.estudiante = estudiante; }
    public Curso getCurso(){ return curso; }
    public void setCurso(Curso curso){ this.curso = curso; }
    public LocalDate getFechaInscripcion(){ return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion){ this.fechaInscripcion = fechaInscripcion; }
    public String getEstado(){ return estado; }
    public void setEstado(String estado){ this.estado = estado; }
}
