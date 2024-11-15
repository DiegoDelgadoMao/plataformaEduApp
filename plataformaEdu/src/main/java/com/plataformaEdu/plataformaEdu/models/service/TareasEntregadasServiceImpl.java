package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.ITareasEntregadasDao;
import com.plataformaEdu.plataformaEdu.models.entity.TareasEntregadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TareasEntregadasServiceImpl implements ITareasEntregadasService {

    @Autowired
    private ITareasEntregadasDao tareasEntregadasDao;

    @Override
    @Transactional(readOnly = true)
    public List<TareasEntregadas> findAll() {
        return (List<TareasEntregadas>) tareasEntregadasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TareasEntregadas> findById(Long id) {
        return tareasEntregadasDao.findById(id);
    }

    @Override
    @Transactional
    public TareasEntregadas save(TareasEntregadas tareasEntregadas) {
        return tareasEntregadasDao.save(tareasEntregadas);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tareasEntregadasDao.deleteById(id);
    }
}
