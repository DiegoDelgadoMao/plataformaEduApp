package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Calificacion;
import com.plataformaEdu.plataformaEdu.models.service.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionRestController {

    @Autowired
    private ICalificacionService calificacionService;

    // Obtener todas las calificaciones
    @GetMapping
    public List<Calificacion> index() {
        return calificacionService.findAll();
    }

    // Obtener una calificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> show(@PathVariable Long id) {
        Optional<Calificacion> calificacion = calificacionService.findById(id);
        return calificacion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva calificación
    @PostMapping
    public ResponseEntity<Calificacion> create(@RequestBody Calificacion calificacion) {
        Calificacion newCalificacion = calificacionService.save(calificacion);
        return new ResponseEntity<>(newCalificacion, HttpStatus.CREATED);
    }

    // Actualizar una calificación existente
    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> update(@PathVariable Long id, @RequestBody Calificacion calificacionDetails) {
        Optional<Calificacion> calificacion = calificacionService.findById(id);
        if (calificacion.isPresent()) {
            Calificacion calificacionToUpdate = calificacion.get();
            calificacionToUpdate.setEstudiante(calificacionDetails.getEstudiante());
            calificacionToUpdate.setAsignatura(calificacionDetails.getAsignatura());
            calificacionToUpdate.setCalificacion(calificacionDetails.getCalificacion());
            calificacionToUpdate.setFecha(calificacionDetails.getFecha());
            calificacionService.save(calificacionToUpdate);
            return ResponseEntity.ok(calificacionToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una calificación
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (calificacionService.findById(id).isPresent()) {
            calificacionService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
