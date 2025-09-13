package com.example.gestionacademica.dto;
import java.time.LocalDate;
public class InscripcionesPorFechaDTO {
    private LocalDate fecha;
    private Long total;
    public InscripcionesPorFechaDTO(LocalDate fecha, Long total) {
        this.fecha = fecha;
        this.total = total;
    }
    public LocalDate getFecha() { return fecha; }
    public Long getTotal() { return total; }
}