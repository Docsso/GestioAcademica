package com.example.gestionacademica.dto;
import java.time.LocalDate;
public class EstudiantesPorCursoDTO {
    private Long cursoId;
    private String cursoNombre;
    private Long estudianteId;
    private String estudianteNombre;
    private String estudianteEmail;
    private LocalDate fechaInscripcion;
    public EstudiantesPorCursoDTO(Long cursoId, String cursoNombre,
                                  Long estudianteId, String estudianteNombre,
                                  String estudianteEmail, LocalDate fechaInscripcion) {
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.estudianteId = estudianteId;
        this.estudianteNombre = estudianteNombre;
        this.estudianteEmail = estudianteEmail;
        this.fechaInscripcion = fechaInscripcion;
    }
    public Long getCursoId() { return cursoId; }
    public String getCursoNombre() { return cursoNombre; }
    public Long getEstudianteId() { return estudianteId; }
    public String getEstudianteNombre() { return estudianteNombre; }
    public String getEstudianteEmail() { return estudianteEmail; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
}