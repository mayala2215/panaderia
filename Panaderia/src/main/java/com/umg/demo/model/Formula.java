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
@Table(name = "Formula")
@Getter
@Setter
public class Formula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormula")
    private Integer idFormula;
    @Column(name = "cantidad")
    private Float cantidad;
    @OneToMany
    @JoinColumn(name = "medidas_idMedida")
    private List<Medidas> medidas;
    @OneToMany
    @JoinColumn(name = "ingredientes_idIngrediente")
    private List<Ingredientes> ingredientes;
    @OneToMany
    @JoinColumn(name = "productos_idProductos")
    private List<Productos> productos;

}
