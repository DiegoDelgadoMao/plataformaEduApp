package com.plataformaEdu.plataformaEdu.models.dao;

import com.plataformaEdu.plataformaEdu.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);

    @Query("SELECT u FROM Usuario u WHERE u.id NOT IN (SELECT e.usuario.id FROM Estudiante e)")
    List<Usuario> findUsuariosSinEstudiante();
}
