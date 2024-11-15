package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.ICalificacionDao;
import com.plataformaEdu.plataformaEdu.models.entity.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    private ICalificacionDao calificacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Calificacion> findAll() {
        return (List<Calificacion>) calificacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Calificacion> findById(Long id) {
        return calificacionDao.findById(id);
    }

    @Override
    @Transactional
    public Calificacion save(Calificacion calificacion) {
        return calificacionDao.save(calificacion);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        calificacionDao.deleteById(id);
    }
}
