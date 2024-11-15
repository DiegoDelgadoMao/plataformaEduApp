package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.IMensajeDao;
import com.plataformaEdu.plataformaEdu.models.entity.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServiceImpl implements IMensajeService {

    @Autowired
    private IMensajeDao mensajeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Mensaje> findAll() {
        return (List<Mensaje>) mensajeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Mensaje> findById(Long id) {
        return mensajeDao.findById(id);
    }

    @Override
    @Transactional
    public Mensaje save(Mensaje mensaje) {
        return mensajeDao.save(mensaje);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        mensajeDao.deleteById(id);
    }
}
