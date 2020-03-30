package com.pictulieter.pagina_oficial.dao;

import com.pictulieter.pagina_oficial.modelo.Imagen;
import com.pictulieter.pagina_oficial.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImagenDAO extends CrudRepository <Imagen,Integer> {

    @Override
    List<Imagen> findAll();

    public Imagen findById(int id);

    public List<Imagen> findByTipo(int tipo);

}
