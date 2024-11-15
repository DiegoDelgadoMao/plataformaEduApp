package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Curso;
import com.plataformaEdu.plataformaEdu.models.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

    @Autowired
    private ICursoService cursoService;

    // Obtener todos los cursos
    @GetMapping
    public List<Curso> index() {
        return cursoService.findAll();
    }

    // Obtener un curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> show(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo curso
    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        Curso newCurso = cursoService.save(curso);
        return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
    }

    // Actualizar un curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            Curso cursoToUpdate = curso.get();
            cursoToUpdate.setNombre(cursoDetails.getNombre());
            cursoToUpdate.setDocente(cursoDetails.getDocente());
            cursoService.save(cursoToUpdate);
            return ResponseEntity.ok(cursoToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (cursoService.findById(id).isPresent()) {
            cursoService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
