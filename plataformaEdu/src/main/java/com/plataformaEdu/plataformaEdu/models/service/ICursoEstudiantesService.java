package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.CursoEstudiantes;
import java.util.List;
import java.util.Optional;

public interface ICursoEstudiantesService {

    List<CursoEstudiantes> findAll();

    Optional<CursoEstudiantes> findById(Long id);

    CursoEstudiantes save(CursoEstudiantes cursoEstudiantes);

    void delete(Long id);
}
