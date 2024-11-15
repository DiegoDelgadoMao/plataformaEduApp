package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Asignatura;
import org.springframework.data.repository.CrudRepository;

public interface IAsignaturaDao extends CrudRepository<Asignatura, Long> {
}