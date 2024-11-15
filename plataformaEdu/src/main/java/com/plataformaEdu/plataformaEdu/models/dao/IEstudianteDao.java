package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {
}
