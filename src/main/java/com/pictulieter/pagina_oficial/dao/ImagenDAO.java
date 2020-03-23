package com.pictulieter.pagina_oficial.dao;

import com.pictulieter.pagina_oficial.modelo.Imagen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImagenDAO extends CrudRepository <Imagen,Integer> {

    @Override
    List<Imagen> findAll();

    @Override
    Optional<Imagen> findById(Integer id);
}
