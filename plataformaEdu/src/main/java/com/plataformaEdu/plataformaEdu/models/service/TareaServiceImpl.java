package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.ITareaDao;
import com.plataformaEdu.plataformaEdu.models.entity.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements ITareaService {

    @Autowired
    private ITareaDao tareaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tarea> findById(Long id) {
        return tareaDao.findById(id);
    }

    @Override
    @Transactional
    public Tarea save(Tarea tarea) {
        return tareaDao.save(tarea);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tareaDao.deleteById(id);
    }
}
