package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Material;
import com.plataformaEdu.plataformaEdu.models.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiales")
public class MaterialRestController {

    @Autowired
    private IMaterialService materialService;

    // Obtener todos los materiales
    @GetMapping
    public List<Material> index() {
        return materialService.findAll();
    }

    // Obtener un material por ID
    @GetMapping("/{id}")
    public ResponseEntity<Material> show(@PathVariable Long id) {
        Optional<Material> material = materialService.findById(id);
        return material.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo material
    @PostMapping
    public ResponseEntity<Material> create(@RequestBody Material material) {
        Material newMaterial = materialService.save(material);
        return new ResponseEntity<>(newMaterial, HttpStatus.CREATED);
    }

    // Actualizar un material existente
    @PutMapping("/{id}")
    public ResponseEntity<Material> update(@PathVariable Long id, @RequestBody Material materialDetails) {
        Optional<Material> material = materialService.findById(id);
        if (material.isPresent()) {
            Material materialToUpdate = material.get();
            materialToUpdate.setTitulo(materialDetails.getTitulo());
            materialToUpdate.setDescripcion(materialDetails.getDescripcion());
            materialToUpdate.setArchivoUrl(materialDetails.getArchivoUrl());
            materialToUpdate.setDocente(materialDetails.getDocente());
            materialService.save(materialToUpdate);
            return ResponseEntity.ok(materialToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un material
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (materialService.findById(id).isPresent()) {
            materialService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
