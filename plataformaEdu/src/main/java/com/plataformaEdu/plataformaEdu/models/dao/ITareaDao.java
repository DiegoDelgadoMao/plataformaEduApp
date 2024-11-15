package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface ITareaDao extends CrudRepository<Tarea, Long> {
}
