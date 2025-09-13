package com.example.gestionacademica.dto;
public class TotalInscripcionesPorProfesorDTO {
    private Long profesorId;
    private String profesorNombre;
    private Long totalInscripciones;
    public TotalInscripcionesPorProfesorDTO(Long profesorId, String profesorNombre, Long totalInscripciones) {
        this.profesorId = profesorId;
        this.profesorNombre = profesorNombre;
        this.totalInscripciones = totalInscripciones;
    }
    public Long getProfesorId() { return profesorId; }
    public String getProfesorNombre() { return profesorNombre; }
    public Long getTotalInscripciones() { return totalInscripciones; }
}