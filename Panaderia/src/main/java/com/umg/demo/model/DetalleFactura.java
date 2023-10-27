package com.umg.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DetalleFactura")
@Getter
@Setter
public class DetalleFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Column(name = "cantidad")
    private Float cantidad;
    @OneToMany
    @JoinColumn(name = "factura_idFactura")
    private List<Factura> facturas;
    @OneToMany
    @JoinColumn(name = "productos_idProductos")
    private List<Productos> productos;

}
