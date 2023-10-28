package com.umg.demo.service;

import java.util.List;
import java.util.Optional;

import com.umg.demo.model.Factura;

public interface IFactura {

    public List<Factura> findAll();

    public Factura save(Factura factura);

    public boolean delete(Integer id);

    public Optional<Factura> findById(Integer id);

}
