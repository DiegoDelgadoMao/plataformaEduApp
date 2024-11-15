package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Tarea;
import com.plataformaEdu.plataformaEdu.models.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaRestController {

    @Autowired
    private ITareaService tareaService;

    // Obtener todas las tareas
    @GetMapping
    public List<Tarea> index() {
        return tareaService.findAll();
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> show(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.findById(id);
        return tarea.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva tarea
    @PostMapping
    public ResponseEntity<Tarea> create(@RequestBody Tarea tarea) {
        Tarea newTarea = tareaService.save(tarea);
        return new ResponseEntity<>(newTarea, HttpStatus.CREATED);
    }

    // Actualizar una tarea existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> update(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        Optional<Tarea> tarea = tareaService.findById(id);
        if (tarea.isPresent()) {
            Tarea tareaToUpdate = tarea.get();
            tareaToUpdate.setTitulo(tareaDetails.getTitulo());
            tareaToUpdate.setDescripcion(tareaDetails.getDescripcion());
            tareaToUpdate.setCurso(tareaDetails.getCurso());
            tareaToUpdate.setFechaEntrega(tareaDetails.getFechaEntrega());
            tareaService.save(tareaToUpdate);
            return ResponseEntity.ok(tareaToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (tareaService.findById(id).isPresent()) {
            tareaService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
