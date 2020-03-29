package com.pictulieter.pagina_oficial.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name="apodo")
    private String apodo;

    @Basic
    @Column(name = "correo")
    private String correo;

    @Basic
    @Column(name = "tipo")
    private Integer tipo;

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<Imagen> imagensById;

    @Basic
    @Column(name = "contraseña")
    private String contraseña;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


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


    public Collection<Imagen> getImagensById() {
        return imagensById;
    }

    public void setImagensById(Collection<Imagen> imagensById) {
        this.imagensById = imagensById;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
