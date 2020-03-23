package com.pictulieter.pagina_oficial.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Imagen {
    private int id;
    private String descripcion;
    private String ruta;
    private Integer tipo;
    private Usuario usuarioByIdUsuario;
    private String comentarios;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ruta")
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Basic
    @Column(name = "tipo")
    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagen imagen = (Imagen) o;
        return id == imagen.id &&
                Objects.equals(descripcion, imagen.descripcion) &&
                Objects.equals(ruta, imagen.ruta) &&
                Objects.equals(tipo, imagen.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, ruta, tipo);
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @Basic
    @Column(name = "comentarios")
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
