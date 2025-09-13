package com.example.gestionacademica.dto;
public class CursosSinInscritosDTO {
    private Long cursoId;
    private String cursoNombre;
    private String profesorNombre;
    public CursosSinInscritosDTO(Long cursoId, String cursoNombre, String profesorNombre) {
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.profesorNombre = profesorNombre;
    }
    public Long getCursoId() { return cursoId; }
    public String getCursoNombre() { return cursoNombre; }
    public String getProfesorNombre() { return profesorNombre; }
}