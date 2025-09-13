package com.example.gestionacademica.controller;
import com.example.gestionacademica.dto.*;
import com.example.gestionacademica.service.ReporteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    private final ReporteService service;
    public ReporteController(ReporteService service) { this.service = service; }
    @GetMapping("/estudiantes-por-curso/{cursoId}")
    public List<EstudiantesPorCursoDTO> estudiantesPorCurso(@PathVariable Long cursoId) { return service.estudiantesPorCurso(cursoId); }
    @GetMapping("/inscripciones-por-curso")
    public List<TotalInscripcionesPorCursoDTO> totalInscripcionesPorCurso() { return service.totalInscripcionesPorCurso(); }
    @GetMapping("/inscripciones-por-profesor")
    public List<TotalInscripcionesPorProfesorDTO> totalInscripcionesPorProfesor() { return service.totalInscripcionesPorProfesor(); }
    @GetMapping("/cursos-por-profesor/{profesorId}")
    public List<CursosPorProfesorDTO> cursosPorProfesor(@PathVariable Long profesorId) { return service.cursosPorProfesor(profesorId); }
    @GetMapping("/estudiantes-sin-inscripcion")
    public List<EstudiantesSinInscripcionDTO> estudiantesSinInscripcion() { return service.estudiantesSinInscripcion(); }
    @GetMapping("/cursos-sin-inscritos")
    public List<CursosSinInscritosDTO> cursosSinInscritos() { return service.cursosSinInscritos(); }
    @GetMapping("/inscripciones-por-fecha")
    public List<InscripcionesPorFechaDTO> inscripcionesPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return service.inscripcionesPorFecha(desde, hasta);
    }
}