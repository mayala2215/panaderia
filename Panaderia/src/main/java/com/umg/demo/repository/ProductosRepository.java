package com.umg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umg.demo.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
