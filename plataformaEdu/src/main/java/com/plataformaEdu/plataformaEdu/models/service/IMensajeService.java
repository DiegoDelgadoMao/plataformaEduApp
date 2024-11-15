package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Mensaje;

import java.util.List;
import java.util.Optional;

public interface IMensajeService {

    List<Mensaje> findAll();

    Optional<Mensaje> findById(Long id);

    Mensaje save(Mensaje mensaje);

    void delete(Long id);
}
