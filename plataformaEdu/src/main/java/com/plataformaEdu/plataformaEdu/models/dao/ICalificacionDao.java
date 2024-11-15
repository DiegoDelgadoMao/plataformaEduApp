package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Calificacion;
import org.springframework.data.repository.CrudRepository;

public interface ICalificacionDao extends CrudRepository<Calificacion, Long> {
}
