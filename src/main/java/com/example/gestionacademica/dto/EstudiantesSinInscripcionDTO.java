package com.example.gestionacademica.dto;
public class EstudiantesSinInscripcionDTO {
    private Long estudianteId;
    private String nombre;
    private String email;
    public EstudiantesSinInscripcionDTO(Long estudianteId, String nombre, String email) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.email = email;
    }
    public Long getEstudianteId() { return estudianteId; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}