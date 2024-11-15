package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Material;
import org.springframework.data.repository.CrudRepository;

public interface IMaterialDao extends CrudRepository<Material, Long> {
}
