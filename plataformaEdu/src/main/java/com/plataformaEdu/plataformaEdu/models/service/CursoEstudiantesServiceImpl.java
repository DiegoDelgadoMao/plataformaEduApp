package com.plataformaEdu.plataformaEdu.models.service;

import com.plataformaEdu.plataformaEdu.models.dao.ICursoEstudiantesDao;
import com.plataformaEdu.plataformaEdu.models.entity.CursoEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoEstudiantesServiceImpl implements ICursoEstudiantesService {

    @Autowired
    private ICursoEstudiantesDao cursoEstudiantesDao;

    @Override
    @Transactional(readOnly = true)
    public List<CursoEstudiantes> findAll() {
        return (List<CursoEstudiantes>) cursoEstudiantesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoEstudiantes> findById(Long id) {
        return cursoEstudiantesDao.findById(id);
    }

    @Override
    @Transactional
    public CursoEstudiantes save(CursoEstudiantes cursoEstudiantes) {
        return cursoEstudiantesDao.save(cursoEstudiantes);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cursoEstudiantesDao.deleteById(id);
    }
}
