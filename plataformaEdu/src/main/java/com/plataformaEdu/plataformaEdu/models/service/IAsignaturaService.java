package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Asignatura;

import java.util.List;
import java.util.Optional;

public interface IAsignaturaService {

    List<Asignatura> findAll();

    Optional<Asignatura> findById(Long id);

    Asignatura save(Asignatura asignatura);

    void delete(Long id);
}
