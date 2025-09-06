package com.example.gestionacademica.repository;

import com.example.gestionacademica.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // List<Curso> findByNombreContainingIgnoreCase(String nombre);
    // List<Curso> findByProfesorId(Long profesorId);
}
