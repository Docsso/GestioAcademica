package com.example.gestionacademica.service;
import com.example.gestionacademica.dto.*;
import com.example.gestionacademica.repository.ReporteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class ReporteService {
    private final ReporteRepository repo;
    public ReporteService(ReporteRepository repo) { this.repo = repo; }
    public List<EstudiantesPorCursoDTO> estudiantesPorCurso(Long cursoId) { return repo.estudiantesPorCurso(cursoId); }
    public List<TotalInscripcionesPorCursoDTO> totalInscripcionesPorCurso() { return repo.totalInscripcionesPorCurso(); }
    public List<TotalInscripcionesPorProfesorDTO> totalInscripcionesPorProfesor() { return repo.totalInscripcionesPorProfesor(); }
    public List<CursosPorProfesorDTO> cursosPorProfesor(Long profesorId) { return repo.cursosPorProfesor(profesorId); }
    public List<EstudiantesSinInscripcionDTO> estudiantesSinInscripcion() { return repo.estudiantesSinInscripcion(); }
    public List<CursosSinInscritosDTO> cursosSinInscritos() { return repo.cursosSinInscritos(); }
    public List<InscripcionesPorFechaDTO> inscripcionesPorFecha(LocalDate desde, LocalDate hasta) { return repo.inscripcionesPorFecha(desde, hasta); }
}