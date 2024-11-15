package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Mensaje;
import com.plataformaEdu.plataformaEdu.models.service.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeRestController {

    @Autowired
    private IMensajeService mensajeService;

    // Obtener todos los mensajes
    @GetMapping
    public List<Mensaje> index() {
        return mensajeService.findAll();
    }

    // Obtener un mensaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> show(@PathVariable Long id) {
        Optional<Mensaje> mensaje = mensajeService.findById(id);
        return mensaje.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<Mensaje> create(@RequestBody Mensaje mensaje) {
        Mensaje newMensaje = mensajeService.save(mensaje);
        return new ResponseEntity<>(newMensaje, HttpStatus.CREATED);
    }

    // Actualizar un mensaje existente
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable Long id, @RequestBody Mensaje mensajeDetails) {
        Optional<Mensaje> mensaje = mensajeService.findById(id);
        if (mensaje.isPresent()) {
            Mensaje mensajeToUpdate = mensaje.get();
            mensajeToUpdate.setRemitente(mensajeDetails.getRemitente());
            mensajeToUpdate.setDestinatario(mensajeDetails.getDestinatario());
            mensajeToUpdate.setMensaje(mensajeDetails.getMensaje());
            mensajeService.save(mensajeToUpdate);
            return ResponseEntity.ok(mensajeToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un mensaje
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (mensajeService.findById(id).isPresent()) {
            mensajeService.delete(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}
