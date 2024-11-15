package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.IAsistenciaDao;
import com.plataformaEdu.plataformaEdu.models.entity.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    private IAsistenciaDao asistenciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asistencia> findAll() {
        return (List<Asistencia>) asistenciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asistencia> findById(Long id) {
        return asistenciaDao.findById(id);
    }

    @Override
    @Transactional
    public Asistencia save(Asistencia asistencia) {
        return asistenciaDao.save(asistencia);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        asistenciaDao.deleteById(id);
    }
}
