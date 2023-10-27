package com.umg.demo.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

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
@Table(name = "Ingredientes")
@Getter
@Setter
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIngrediente")
    private Integer idIngrediente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "stock")
    private Float stock;
    @OneToMany
    @JoinColumn(name = "proveedores_idProveedor")
    private List<Proveedores> proveedores;

}
