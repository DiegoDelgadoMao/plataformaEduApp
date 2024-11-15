package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.CursoEstudiantes;
import com.plataformaEdu.plataformaEdu.models.service.ICursoEstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curso_estudiantes")
public class CursoEstudiantesRestController {

    @Autowired
    private ICursoEstudiantesService cursoEstudiantesService;

    // Obtener todos los registros de curso_estudiantes
    @GetMapping
    public List<CursoEstudiantes> index() {
        return cursoEstudiantesService.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<CursoEstudiantes> show(@PathVariable Long id) {
        Optional<CursoEstudiantes> cursoEstudiantes = cursoEstudiantesService.findById(id);
        return cursoEstudiantes.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro de curso_estudiantes
    @PostMapping
    public ResponseEntity<CursoEstudiantes> create(@RequestBody CursoEstudiantes cursoEstudiantes) {
        CursoEstudiantes newCursoEstudiantes = cursoEstudiantesService.save(cursoEstudiantes);
        return new ResponseEntity<>(newCursoEstudiantes, HttpStatus.CREATED);
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<CursoEstudiantes> update(@PathVariable Long id, @RequestBody CursoEstudiantes cursoEstudiantesDetails) {
        Optional<CursoEstudiantes> cursoEstudiantes = cursoEstudiantesService.findById(id);
        if (cursoEstudiantes.isPresent()) {
            CursoEstudiantes cursoEstudiantesToUpdate = cursoEstudiantes.get();
            cursoEstudiantesToUpdate.setCurso(cursoEstudiantesDetails.getCurso());
            cursoEstudiantesToUpdate.setEstudiante(cursoEstudiantesDetails.getEstudiante());
            cursoEstudiantesService.save(cursoEstudiantesToUpdate);
            return ResponseEntity.ok(cursoEstudiantesToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro de curso_estudiantes
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (cursoEstudiantesService.findById(id).isPresent()) {
            cursoEstudiantesService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
