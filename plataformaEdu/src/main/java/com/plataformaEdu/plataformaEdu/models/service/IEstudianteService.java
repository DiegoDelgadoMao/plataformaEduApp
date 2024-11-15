package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {

    List<Estudiante> findAll();

    Optional<Estudiante> findById(Long id);

    Estudiante save(Estudiante estudiante);

    void delete(Long id);
}
