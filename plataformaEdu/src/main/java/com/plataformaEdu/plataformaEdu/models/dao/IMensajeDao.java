package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface IMensajeDao extends CrudRepository<Mensaje, Long> {
}
