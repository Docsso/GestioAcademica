package com.example.gestionacademica.dto;
public class CursosPorProfesorDTO {
    private Long profesorId;
    private String profesorNombre;
    private Long cursoId;
    private String cursoNombre;
    public CursosPorProfesorDTO(Long profesorId, String profesorNombre, Long cursoId, String cursoNombre) {
        this.profesorId = profesorId;
        this.profesorNombre = profesorNombre;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
    }
    public Long getProfesorId() { return profesorId; }
    public String getProfesorNombre() { return profesorNombre; }
    public Long getCursoId() { return cursoId; }
    public String getCursoNombre() { return cursoNombre; }
}