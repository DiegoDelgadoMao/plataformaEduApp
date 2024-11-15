package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface ICursoDao extends CrudRepository<Curso, Long> {
}
