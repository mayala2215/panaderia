package com.umg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umg.demo.model.DetalleFactura;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

}
