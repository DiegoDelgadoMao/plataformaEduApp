package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Asignatura;
import com.plataformaEdu.plataformaEdu.models.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaRestController {

    @Autowired
    private IAsignaturaService asignaturaService;

    // Obtener todas las asignaturas
    @GetMapping
    public List<Asignatura> index() {
        return asignaturaService.findAll();
    }

    // Obtener una asignatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> show(@PathVariable Long id) {
        Optional<Asignatura> asignatura = asignaturaService.findById(id);
        return asignatura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva asignatura
    @PostMapping
    public ResponseEntity<Asignatura> create(@RequestBody Asignatura asignatura) {
        Asignatura newAsignatura = asignaturaService.save(asignatura);
        return new ResponseEntity<>(newAsignatura, HttpStatus.CREATED);
    }

    // Actualizar una asignatura existente
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> update(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        Optional<Asignatura> asignatura = asignaturaService.findById(id);
        if (asignatura.isPresent()) {
            Asignatura asignaturaToUpdate = asignatura.get();
            asignaturaToUpdate.setNombre(asignaturaDetails.getNombre());
            asignaturaService.save(asignaturaToUpdate);
            return ResponseEntity.ok(asignaturaToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (asignaturaService.findById(id).isPresent()) {
            asignaturaService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}