package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.TareasEntregadas;
import com.plataformaEdu.plataformaEdu.models.service.ITareasEntregadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas_entregadas")
public class TareasEntregadasRestController {

    @Autowired
    private ITareasEntregadasService tareasEntregadasService;

    // Obtener todos los registros de tareas_entregadas
    @GetMapping
    public List<TareasEntregadas> index() {
        return tareasEntregadasService.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<TareasEntregadas> show(@PathVariable Long id) {
        Optional<TareasEntregadas> tareasEntregadas = tareasEntregadasService.findById(id);
        return tareasEntregadas.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro de tareas_entregadas
    @PostMapping
    public ResponseEntity<TareasEntregadas> create(@RequestBody TareasEntregadas tareasEntregadas) {
        TareasEntregadas newTareasEntregadas = tareasEntregadasService.save(tareasEntregadas);
        return new ResponseEntity<>(newTareasEntregadas, HttpStatus.CREATED);
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<TareasEntregadas> update(@PathVariable Long id, @RequestBody TareasEntregadas tareasEntregadasDetails) {
        Optional<TareasEntregadas> tareasEntregadas = tareasEntregadasService.findById(id);
        if (tareasEntregadas.isPresent()) {
            TareasEntregadas tareasEntregadasToUpdate = tareasEntregadas.get();
            tareasEntregadasToUpdate.setTarea(tareasEntregadasDetails.getTarea());
            tareasEntregadasToUpdate.setEstudiante(tareasEntregadasDetails.getEstudiante());
            tareasEntregadasToUpdate.setFechaEntrega(tareasEntregadasDetails.getFechaEntrega());
            tareasEntregadasToUpdate.setArchivoUrl(tareasEntregadasDetails.getArchivoUrl());
            tareasEntregadasService.save(tareasEntregadasToUpdate);
            return ResponseEntity.ok(tareasEntregadasToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro de tareas_entregadas
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (tareasEntregadasService.findById(id).isPresent()) {
            tareasEntregadasService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
