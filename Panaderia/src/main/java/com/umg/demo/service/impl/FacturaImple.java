package com.umg.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.demo.model.Factura;
import com.umg.demo.repository.FacturaRepository;
import com.umg.demo.service.IFactura;

@Service
public class FacturaImple implements IFactura {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public boolean delete(Integer id) {
        facturaRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaRepository.findById(id);
    }

}
