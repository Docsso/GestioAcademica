package com.example.gestionacademica.repository;

import com.example.gestionacademica.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // Optional<Profesor> findByEmail(String email);
}
