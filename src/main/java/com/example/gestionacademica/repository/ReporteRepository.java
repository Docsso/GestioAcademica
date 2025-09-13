package com.example.gestionacademica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestionacademica.dto.CursosPorProfesorDTO;
import com.example.gestionacademica.dto.CursosSinInscritosDTO;
import com.example.gestionacademica.dto.EstudiantesPorCursoDTO;
import com.example.gestionacademica.dto.EstudiantesSinInscripcionDTO;
import com.example.gestionacademica.dto.InscripcionesPorFechaDTO;
import com.example.gestionacademica.dto.TotalInscripcionesPorCursoDTO;
import com.example.gestionacademica.dto.TotalInscripcionesPorProfesorDTO;
import com.example.gestionacademica.model.Inscripcion;

@Repository
public interface ReporteRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT new com.example.gestionacademica.dto.EstudiantesPorCursoDTO(" +
           " c.id, c.nombre, e.id, CONCAT(e.nombres, ' ', e.apellidos), e.email, i.fechaInscripcion) " +
           "FROM Inscripcion i " +
           "JOIN i.curso c " +
           "JOIN i.estudiante e " +
           "WHERE c.id = :cursoId " +
           "ORDER BY e.nombres ASC, e.apellidos ASC")
    List<EstudiantesPorCursoDTO> estudiantesPorCurso(@Param("cursoId") Long cursoId);

    @Query("SELECT new com.example.gestionacademica.dto.TotalInscripcionesPorCursoDTO(" +
           " c.id, c.nombre, COUNT(i.id)) " +
           "FROM Inscripcion i JOIN i.curso c " +
           "GROUP BY c.id, c.nombre " +
           "ORDER BY COUNT(i.id) DESC")
    List<TotalInscripcionesPorCursoDTO> totalInscripcionesPorCurso();

    @Query("SELECT new com.example.gestionacademica.dto.TotalInscripcionesPorProfesorDTO(" +
           " p.id, p.nombre, COUNT(i.id)) " +
           "FROM Inscripcion i JOIN i.curso c JOIN c.profesor p " +
           "GROUP BY p.id, p.nombre " +
           "ORDER BY COUNT(i.id) DESC")
    List<TotalInscripcionesPorProfesorDTO> totalInscripcionesPorProfesor();

    @Query("SELECT new com.example.gestionacademica.dto.CursosPorProfesorDTO(" +
           " p.id, p.nombre, c.id, c.nombre) " +
           "FROM Curso c JOIN c.profesor p " +
           "WHERE p.id = :profesorId " +
           "ORDER BY c.nombre ASC")
    List<CursosPorProfesorDTO> cursosPorProfesor(@Param("profesorId") Long profesorId);

    @Query("SELECT new com.example.gestionacademica.dto.EstudiantesSinInscripcionDTO(" +
           " e.id, CONCAT(e.nombres, ' ', e.apellidos), e.email) " +
           "FROM Estudiante e " +
           "WHERE e.id NOT IN (SELECT i.estudiante.id FROM Inscripcion i) " +
           "ORDER BY e.nombres ASC, e.apellidos ASC")
    List<EstudiantesSinInscripcionDTO> estudiantesSinInscripcion();

    @Query("SELECT new com.example.gestionacademica.dto.CursosSinInscritosDTO(" +
           " c.id, c.nombre, p.nombre) " +
           "FROM Curso c JOIN c.profesor p " +
           "WHERE c.id NOT IN (SELECT i.curso.id FROM Inscripcion i) " +
           "ORDER BY c.nombre ASC")
    List<CursosSinInscritosDTO> cursosSinInscritos();

    @Query("SELECT new com.example.gestionacademica.dto.InscripcionesPorFechaDTO(" +
           " i.fechaInscripcion, COUNT(i.id)) " +
           "FROM Inscripcion i " +
           "WHERE i.fechaInscripcion BETWEEN :desde AND :hasta " +
           "GROUP BY i.fechaInscripcion " +
           "ORDER BY i.fechaInscripcion ASC")
    List<InscripcionesPorFechaDTO> inscripcionesPorFecha(@Param("desde") LocalDate desde,
                                                          @Param("hasta") LocalDate hasta);
}
