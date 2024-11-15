package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.TareasEntregadas;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ITareasEntregadasDao extends CrudRepository<TareasEntregadas, Long> {

    @Modifying
    @Query("DELETE FROM TareasEntregadas t WHERE t.estudiante.id = :estudianteId")
    void deleteByEstudianteId(@Param("estudianteId") Long estudianteId);

}
