package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.entity.Material;

import java.util.List;
import java.util.Optional;

public interface IMaterialService {

    List<Material> findAll();

    Optional<Material> findById(Long id);

    Material save(Material material);

    void delete(Long id);
}
