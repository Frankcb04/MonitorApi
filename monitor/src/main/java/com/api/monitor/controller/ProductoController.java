package com.api.monitor.controller;

import com.api.monitor.model.Producto;
import com.api.monitor.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/listarProductos")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/listarProducto/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Crear un nuevo producto
    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto createdProducto = productoService.createProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }

    // Actualizar un producto
    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updatedProducto = productoService.updateProducto(id, producto);
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un producto
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        boolean isDeleted = productoService.deleteProducto(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
