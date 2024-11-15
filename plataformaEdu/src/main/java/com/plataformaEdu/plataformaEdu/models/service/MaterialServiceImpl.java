package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.IMaterialDao;
import com.plataformaEdu.plataformaEdu.models.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private IMaterialDao materialDao;

    @Override
    @Transactional(readOnly = true)
    public List<Material> findAll() {
        return (List<Material>) materialDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Material> findById(Long id) {
        return materialDao.findById(id);
    }

    @Override
    @Transactional
    public Material save(Material material) {
        return materialDao.save(material);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        materialDao.deleteById(id);
    }
}
