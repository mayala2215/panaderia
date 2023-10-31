package com.umg.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.umg.demo.model.DetalleFactura;
import com.umg.demo.model.Factura;
import com.umg.demo.model.Productos;
import com.umg.demo.service.IDetalleFactura;
import com.umg.demo.service.IFactura;
import com.umg.demo.service.IProductos;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.soap.SOAPException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/umg")
public class PanaderiaController {

    @Autowired
    IProductos iProductos;

    @Autowired
    IFactura iFactura;

    @Autowired
    IDetalleFactura iDetalleFactura;

    @Autowired
    IProductos iProductos3;

    @PostMapping("/list/products")
    public ResponseEntity<List<Productos>> getProducts(@RequestBody String data)
            throws IOException,
            SOAPException, JAXBException {
        log.info("data: {}", data);

        return ResponseEntity.ok(iProductos.findAll());
    }

    @PostMapping("/list/facturas")
    public ResponseEntity<List<Factura>> getFacturas(@RequestBody String data)
            throws IOException,
            SOAPException, JAXBException {
        log.info("data: {}", data);

        return ResponseEntity.ok(iFactura.findAll());
    }

    @PostMapping("/list/facturas/id")
    public ResponseEntity<Factura> getFacturaId(@RequestBody Integer data)
            throws IOException,
            SOAPException, JAXBException {
        Factura factura = new Factura();
        if (data != null) {
            Optional<Factura> tmFactura = iFactura.findById(data);
            if (tmFactura.isPresent()) {
                factura = tmFactura.get();
                return ResponseEntity.ok(factura);
            }
        }
        log.info("data: {}", data);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/list/productos/id")
    public ResponseEntity<Productos> productoId(@RequestBody Integer data)
            throws IOException,
            SOAPException, JAXBException {
        Productos productos = new Productos();
        if (data != null) {
            Optional<Productos> tmFactura = iProductos.findById(data);
            if (tmFactura.isPresent()) {
                productos = tmFactura.get();
                return ResponseEntity.ok(productos);
            }
        }
        log.info("data: {}", data);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/save/pedidos")
    public ResponseEntity<Factura> despachaPedido(@RequestBody Factura facturas)
            throws IOException,
            SOAPException, JAXBException {

        float totalFactura = 0;
        JsonMapper mapper = new JsonMapper();
        log.info("data: {}", mapper.writeValueAsString(facturas));
        // Declaramos el detalle a guardar
        DetalleFactura newDetalleFactura = new DetalleFactura();
        // Lista de productos a descontar
        List<Productos> productos = new ArrayList<>();

        Factura newFactura = new Factura();
        newFactura.setClientes(facturas.getClientes());
        newFactura.setNit(facturas.getNit());
        newFactura.setFechaFactura(facturas.getFechaFactura());
        newFactura.setTotalFactura(facturas.getTotalFactura());

        Factura factura = iFactura.save(newFactura);

        for (DetalleFactura deta : facturas.getDetalleFacturas()) {
            Productos temProductos = new Productos();
            temProductos.setIdProductos(deta.getProductos().getIdProductos());
            temProductos.setStock(deta.getCantidad());
            productos.add(temProductos);

            Optional<Productos> tmProductos = iProductos.findById(temProductos.getIdProductos());
            if (tmProductos.isPresent()) {
                Productos newP = tmProductos.get();
                if (newP.getStock() >= deta.getCantidad()) {
                    newP.setStock(newP.getStock() - deta.getCantidad());
                    iProductos.save(newP);
                    deta.setFacturas(factura);
                    iDetalleFactura.save(deta);
                    totalFactura += newP.getPrecio() * deta.getCantidad();
                }
            }

        }
        factura.setTotalFactura(totalFactura);
        factura = iFactura.save(factura);
        if (factura.getIdFactura() != null) {
            return ResponseEntity.ok(factura);
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping("/save/productos")
    public ResponseEntity<Productos> saveProductos(@RequestBody Productos productos)
            throws IOException,
            SOAPException, JAXBException {
        if (productos != null) {

            Productos newProductos = iProductos.save(productos);
            if (newProductos != null) {
                return ResponseEntity.ok(newProductos);
            }

        }

        return ResponseEntity.badRequest().build();
    }

}
