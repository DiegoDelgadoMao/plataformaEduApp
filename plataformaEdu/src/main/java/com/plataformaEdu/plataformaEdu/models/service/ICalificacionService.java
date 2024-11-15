package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Calificacion;

import java.util.List;
import java.util.Optional;

public interface ICalificacionService {

    List<Calificacion> findAll();

    Optional<Calificacion> findById(Long id);

    Calificacion save(Calificacion calificacion);

    void delete(Long id);
}
