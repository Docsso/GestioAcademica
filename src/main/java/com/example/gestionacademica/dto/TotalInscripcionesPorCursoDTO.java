package com.example.gestionacademica.dto;
public class TotalInscripcionesPorCursoDTO {
    private Long cursoId;
    private String cursoNombre;
    private Long totalInscripciones;
    public TotalInscripcionesPorCursoDTO(Long cursoId, String cursoNombre, Long totalInscripciones) {
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.totalInscripciones = totalInscripciones;
    }
    public Long getCursoId() { return cursoId; }
    public String getCursoNombre() { return cursoNombre; }
    public Long getTotalInscripciones() { return totalInscripciones; }
}