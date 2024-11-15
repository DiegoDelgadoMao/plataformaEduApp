package com.plataformaEdu.plataformaEdu.controllers;

import com.plataformaEdu.plataformaEdu.models.entity.Usuario;
import com.plataformaEdu.plataformaEdu.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String correo, @RequestParam String contrasena) {
        Optional<Usuario> usuario = usuarioService.findByCorreo(correo); // Cambiado a findByCorreo
        if (usuario.isPresent()) {
            if (usuario.get().getContrasena().equals(contrasena)) {
                return ResponseEntity.ok("Login exitoso");
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuario no registrado");
        }
    }
}
