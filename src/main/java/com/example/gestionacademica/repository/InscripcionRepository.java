package com.example.gestionacademica.repository;

import com.example.gestionacademica.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    // boolean existsByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);
    // List<Inscripcion> findByEstudianteId(Long estudianteId);
    // List<Inscripcion> findByCursoId(Long cursoId);
}
