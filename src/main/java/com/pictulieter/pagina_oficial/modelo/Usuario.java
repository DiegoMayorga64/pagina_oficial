package com.pictulieter.pagina_oficial.modelo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    private int id;
    private String nombre;
    private String apodo;
    private String correo;
    private Integer tipo;
    private Collection<Imagen> imagensById;
    private String contraseña;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apodo")
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Basic
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apodo, usuario.apodo) &&
                Objects.equals(correo, usuario.correo) &&
                Objects.equals(contraseña, usuario.contraseña) &&
                Objects.equals(tipo, usuario.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apodo, correo, contraseña, tipo);
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Imagen> getImagensById() {
        return imagensById;
    }

    public void setImagensById(Collection<Imagen> imagensById) {
        this.imagensById = imagensById;
    }

    @Basic
    @Column(name = "contraseña")
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
