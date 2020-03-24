package com.pictulieter.pagina_oficial.dao;

import org.springframework.data.repository.CrudRepository;
import com.pictulieter.pagina_oficial.modelo.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioDAO extends CrudRepository <Usuario, Integer> {

    @Override
    List<Usuario> findAll();

//    public Optional<Usuario> findById(Integer id);

    public Usuario findById(int id);

    public Usuario findByCorreoAndContraseña(String email,String pass);
}
