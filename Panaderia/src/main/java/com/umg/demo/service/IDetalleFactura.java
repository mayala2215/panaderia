package com.umg.demo.service;

import java.util.List;
import java.util.Optional;

import com.umg.demo.model.DetalleFactura;

public interface IDetalleFactura {

    public List<DetalleFactura> findAll();

    public DetalleFactura save(DetalleFactura detalleFactura);

    public List<DetalleFactura> saveAll(List<DetalleFactura> detalleFacturas);

    public boolean delete(Integer id);

    public Optional<DetalleFactura> findById(Integer id);
}
