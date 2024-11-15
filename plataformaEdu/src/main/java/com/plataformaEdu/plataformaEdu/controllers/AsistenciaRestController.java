package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Asistencia;
import com.plataformaEdu.plataformaEdu.models.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaRestController {

    @Autowired
    private IAsistenciaService asistenciaService;

    // Obtener todas las asistencias
    @GetMapping
    public List<Asistencia> index() {
        return asistenciaService.findAll();
    }

    // Obtener una asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> show(@PathVariable Long id) {
        Optional<Asistencia> asistencia = asistenciaService.findById(id);
        return asistencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva asistencia
    @PostMapping
    public ResponseEntity<Asistencia> create(@RequestBody Asistencia asistencia) {
        Asistencia newAsistencia = asistenciaService.save(asistencia);
        return new ResponseEntity<>(newAsistencia, HttpStatus.CREATED);
    }

    // Actualizar una asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody Asistencia asistenciaDetails) {
        Optional<Asistencia> asistencia = asistenciaService.findById(id);
        if (asistencia.isPresent()) {
            Asistencia asistenciaToUpdate = asistencia.get();
            asistenciaToUpdate.setEstudiante(asistenciaDetails.getEstudiante());
            asistenciaToUpdate.setFecha(asistenciaDetails.getFecha());
            asistenciaToUpdate.setEstado(asistenciaDetails.getEstado());
            asistenciaService.save(asistenciaToUpdate);
            return ResponseEntity.ok(asistenciaToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (asistenciaService.findById(id).isPresent()) {
            asistenciaService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
