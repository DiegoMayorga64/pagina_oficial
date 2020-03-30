package com.pictulieter.pagina_oficial.modelo;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Imagen implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "descripcion")
    private String descripcion;

    @Basic
    @Column(name = "titulo")
    private String titulo;

    @Basic
    @Column(name = "tipo")
    private int tipo;

    @Basic
    @Column(name="txt")
    private String txt;

    @Basic
    @Column(name="img")
    private File img;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuarioByIdUsuario;

    @Basic
    @Column(name = "comentarios")
    private String comentarios;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String ruta) {
        this.titulo = ruta;
    }


    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagen imagen = (Imagen) o;
        return id == imagen.id &&
                Objects.equals(descripcion, imagen.descripcion) &&
                Objects.equals(titulo, imagen.titulo) &&
                Objects.equals(tipo, imagen.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, titulo, tipo);
    }


    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }


    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getTxt(){
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
