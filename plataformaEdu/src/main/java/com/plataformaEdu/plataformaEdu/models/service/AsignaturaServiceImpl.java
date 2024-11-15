package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.IAsignaturaDao;
import com.plataformaEdu.plataformaEdu.models.entity.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private IAsignaturaDao asignaturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> findAll() {
        return (List<Asignatura>) asignaturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asignatura> findById(Long id) {
        return asignaturaDao.findById(id);
    }

    @Override
    @Transactional
    public Asignatura save(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        asignaturaDao.deleteById(id);
    }
}
