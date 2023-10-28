package com.umg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umg.demo.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
