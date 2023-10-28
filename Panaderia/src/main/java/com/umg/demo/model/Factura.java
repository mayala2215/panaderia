package com.umg.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Factura")
@Getter
@Setter
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "nit")
    private String nit;
    @Column(name = "fechaFactura")
    private String fechaFactura;
    @Column(name = "totalFactura")
    private Float totalFactura;
    @OneToOne
    @JoinColumn(name = "clientes_idCliente")
    private Clientes clientes;
    @JsonManagedReference
    @OneToMany(mappedBy = "facturas", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalleFacturas;

}
