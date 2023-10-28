package com.umg.demo.service;

import java.util.List;
import java.util.Optional;

import com.umg.demo.model.Productos;

public interface IProductos {

    public List<Productos> findAll();

    public Productos save(Productos productos);

    public boolean delete(Integer id);

    public Optional<Productos> findById(Integer id);

}
