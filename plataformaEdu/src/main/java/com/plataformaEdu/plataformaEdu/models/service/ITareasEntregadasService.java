package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.TareasEntregadas;
import java.util.List;
import java.util.Optional;

public interface ITareasEntregadasService {

    List<TareasEntregadas> findAll();

    Optional<TareasEntregadas> findById(Long id);

    TareasEntregadas save(TareasEntregadas tareasEntregadas);

    void delete(Long id);
}
