package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Asistencia;

import java.util.List;
import java.util.Optional;

public interface IAsistenciaService {

    List<Asistencia> findAll();

    Optional<Asistencia> findById(Long id);

    Asistencia save(Asistencia asistencia);

    void delete(Long id);
}
