package com.umg.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.demo.model.Productos;
import com.umg.demo.repository.ProductosRepository;
import com.umg.demo.service.IProductos;

@Service
public class ProductosImple implements IProductos {
    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Productos save(Productos productos) {
        return productosRepository.save(productos);
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Productos> findById(Integer id) {
        return productosRepository.findById(id);
    }

}
