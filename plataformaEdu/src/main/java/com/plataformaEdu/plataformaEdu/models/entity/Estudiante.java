package com.plataformaEdu.plataformaEdu.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.REMOVE)
    @JsonIgnore // Evita la serialización infinita de la relación inversa
    private List<CursoEstudiantes> cursoEstudiantes;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.REMOVE)
    @JsonIgnore // Evita la serialización infinita de la relación inversa
    private List<TareasEntregadas> tareasEntregadas;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.REMOVE)
    private List<Calificacion> calificaciones;

    @Column(nullable = false, length = 50)
    private String grado;

    @Column(nullable = false)
    private boolean activo = true;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<CursoEstudiantes> getCursoEstudiantes() {
        return cursoEstudiantes;
    }

    public void setCursoEstudiantes(List<CursoEstudiantes> cursoEstudiantes) {
        this.cursoEstudiantes = cursoEstudiantes;
    }

    public List<TareasEntregadas> getTareasEntregadas() {
        return tareasEntregadas;
    }

    public void setTareasEntregadas(List<TareasEntregadas> tareasEntregadas) {
        this.tareasEntregadas = tareasEntregadas;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
